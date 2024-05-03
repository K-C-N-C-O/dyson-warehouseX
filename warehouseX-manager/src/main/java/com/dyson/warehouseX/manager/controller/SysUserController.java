package com.dyson.warehouseX.manager.controller;

import com.dyson.model.dto.system.AssignRoleDto;
import com.dyson.model.dto.system.SysUserDto;
import com.dyson.model.dto.system.SysUserInfoDto;
import com.dyson.model.entity.system.SysUser;
import com.dyson.model.entity.system.SysUserInfo;
import com.dyson.model.vo.common.Result;
import com.dyson.model.vo.common.ResultCodeEnum;
import com.dyson.warehouseX.manager.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    //用户分页查询
    @GetMapping(value = "findByPage/{pageNum}/{pageSize}")
//    public Result findByPage(@PathVariable Integer pageNum,
//                             @PathVariable Integer pageSize,
//                             SysUserDto sysUserDto) {
    public Result findByPage(@PathVariable Integer pageNum,
                             @PathVariable Integer pageSize,
                             @RequestParam (name = "keyword",required = false) String keyword) {
        PageInfo<SysUserInfo> pageInfo = sysUserService.findByPage(pageNum, pageSize, keyword);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
    
    //用户添加
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUserInfoDto sysUserInfoDto) {
        sysUserService.saveSysUser(sysUserInfoDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


    //用户修改
    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    //用户删除
    @DeleteMapping(value = "/deleteById/{userId}")
    public Result deleteById(@PathVariable("userId") Long userId) {
        sysUserService.deleteById(userId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    //用户分配角色
    @PostMapping(value = "/doAssign")
    public Result doAssign(@RequestBody AssignRoleDto assignRoleDto) {
        sysUserService.doAssign(assignRoleDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


}
