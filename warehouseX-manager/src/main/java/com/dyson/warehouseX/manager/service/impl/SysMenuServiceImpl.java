package com.dyson.warehouseX.manager.service.impl;

import com.dyson.model.entity.system.SysMenu;
import com.dyson.model.entity.system.SysUser;
import com.dyson.model.vo.common.ResultCodeEnum;
import com.dyson.model.vo.system.SysMenuVo;
import com.dyson.warehouseX.common.exception.PException;
import com.dyson.warehouseX.manager.mapper.SysMenuMapper;
import com.dyson.warehouseX.manager.mapper.SysRoleMenuMapper;
import com.dyson.warehouseX.manager.service.SysMenuService;
import com.dyson.warehouseX.manager.utils.MenuHelper;
import com.dyson.warehouseX.utils.AuthContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper ;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    //菜单列表

    @Override
    public List<SysMenu> findNodes() {
        //查询所有菜单数据,返回List集合
        List<SysMenu> sysMenuList = sysMenuMapper.selectAll() ;
        if (CollectionUtils.isEmpty(sysMenuList)){
            return null;
        }
        //调用工具类的方法，将List集合封装为前端可以解析的数据
        List<SysMenu> treeList = MenuHelper.buildTree(sysMenuList); //构建树形数据
        return treeList;
    }

    //菜单添加

    @Override
    public void save(SysMenu sysMenu) {
        sysMenuMapper.insert(sysMenu);
        //新添加子菜单，需要把父菜单变为半开状态1
        updateSysRoleMenu(sysMenu) ;
    }

    private void updateSysRoleMenu(SysMenu sysMenu) {

        // 查询是否存在父节点
        SysMenu parentMenu = sysMenuMapper.selectParentMenu(sysMenu.getParentId());

        if(parentMenu != null) {
            // 将父菜单 ishalf 值设置为半开 1
            sysRoleMenuMapper.updateSysRoleMenuIsHalf(parentMenu.getId()) ;
            // 递归调用
            updateSysRoleMenu(parentMenu) ;
        }

    }

    //菜单修改

    @Override
    public void updateById(SysMenu sysMenu) {
        sysMenuMapper.updateById(sysMenu) ;
    }

    //菜单删除

    @Override
    public void removeById(Long id) {
        int count = sysMenuMapper.countByParentId(id);  // 先查询是否存在子菜单，如果存在不允许进行删除
        if (count > 0) {
            throw new PException(ResultCodeEnum.NODE_ERROR);
        }
        sysMenuMapper.deleteById(id);		// 不存在子菜单直接删除
    }

    //查看用户可以操纵的菜单
    @Override
    public List<SysMenuVo> findUserMenuList() {
        // 获取当前登录用户的id
        SysUser sysUser = AuthContextUtil.get();
        Long userId = sysUser.getId();

        // 根据id查询可以操作的菜单
        List<SysMenu> sysMenuList = sysMenuMapper.selectListByUserId(userId) ;

        //封装要求数据格式，构建树形数据
        List<SysMenu> sysMenuTreeList = MenuHelper.buildTree(sysMenuList);
        return this.buildMenus(sysMenuTreeList);
    }

    // 将List<SysMenu>对象转换成List<SysMenuVo>对象
    private List<SysMenuVo> buildMenus(List<SysMenu> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<>();
        for (SysMenu sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            List<SysMenu> children = sysMenu.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                sysMenuVo.setChildren(buildMenus(children));
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
}
