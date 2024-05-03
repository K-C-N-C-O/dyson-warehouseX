package com.dyson.warehouseX.manager.service.impl;

import com.dyson.model.dto.system.SysRoleDto;
import com.dyson.model.entity.system.SysRole;
import com.dyson.model.vo.common.Result;
import com.dyson.warehouseX.manager.mapper.SysRoleMapper;
import com.dyson.warehouseX.manager.mapper.SysRoleUserMapper;
import com.dyson.warehouseX.manager.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit) {
        //设置分页参数
        PageHelper.startPage(current,limit);
        //根据条件查询所有数据
        List<SysRole> list=sysRoleMapper.findByPage(sysRoleDto);
        //封装pageInfo对象
        PageInfo<SysRole> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void saveSysRole(SysRole sysRole) {
        sysRoleMapper.save(sysRole);

    }

    //职位修改
    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.update(sysRole);

    }

    //职位删除
    @Override
    public void deleteById(Long roleId) {
        sysRoleMapper.delete(roleId);
    }


    //查询所有职位
    @Override
    public Map<String, Object> findAll(Long userId) {
        //1 查询所有职位
        List<SysRole> roleList=sysRoleMapper.findAll();

        //2 分配过的职位列表
        //根据用户Id查询用户分配过的职位id列表
        List<Long> roleIds=sysRoleUserMapper.selectRoleIdsByUserId(userId);

        Map<String,Object> map=new HashMap<>();
        map.put("allRoleList",roleList);
        map.put("sysUserRoles",roleIds);

        return map;
    }
}
