package com.dyson.warehouseX.manager.mapper;

import com.dyson.model.dto.system.SysUserDto;
import com.dyson.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    SysUser selectUserInfoByUserName(String userName);

    List<SysUser> findByPage(String keyword);

    void save(SysUser sysUser);

    void update(SysUser sysUser);

    void delete(Long userId);
}
