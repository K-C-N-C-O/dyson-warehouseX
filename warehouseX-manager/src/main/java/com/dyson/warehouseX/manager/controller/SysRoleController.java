package com.dyson.warehouseX.manager.controller;

import com.dyson.model.dto.system.SysRoleDto;
import com.dyson.model.entity.system.SysRole;
import com.dyson.model.vo.common.Result;
import com.dyson.model.vo.common.ResultCodeEnum;
import com.dyson.warehouseX.manager.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    //职位查询
    //current ；当前页  limit:每页显示的记录数
    @PostMapping("/findByPage/{current}/{limit}")
    public Result findByPage(@PathVariable("current") Integer current,
                             @PathVariable("limit") Integer limit,
                             @RequestBody SysRoleDto sysRoleDto){

        //pageHelper插件实现分页
        PageInfo<SysRole> pageInfo=sysRoleService.findByPage(sysRoleDto,current,limit);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    //职位添加
    @PostMapping(value = "/saveSysRole")
    public  Result saveSysRole(@RequestBody SysRole sysRole){
        sysRoleService.saveSysRole(sysRole);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    //职位修改
    @PutMapping(value = "/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole){
        sysRoleService.updateSysRole(sysRole);
        return Result.build(null,ResultCodeEnum.SUCCESS);

    }

    //职位删除
    @DeleteMapping(value = "/deleteById/{roleId}")
    public Result deleteById(@PathVariable("roleId") Long roleId){
        sysRoleService.deleteById(roleId);
        return Result.build(null,ResultCodeEnum.SUCCESS);

    }

    //查询所有职位
    @GetMapping(value = "/findAllRoles/{userId}")
    public  Result findAllRoles(@PathVariable("userId") Long userId){
        Map<String,Object> map=sysRoleService.findAll(userId);
        return Result.build(map,ResultCodeEnum.SUCCESS);

    }


}
