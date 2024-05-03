package com.dyson.warehouseX.manager.mapper;

import com.dyson.model.dto.system.AssginMenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper {
    public List<Long> findSysRoleMenuByRoleId(Long roleId);

    public void deleteByRoleId(Long roleId);

    public void doAssign(AssginMenuDto assginMenuDto);

    void updateSysRoleMenuIsHalf(Long menuId);
}
