package com.whoiszxl.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whoiszxl.bean.ResponseResult;
import com.whoiszxl.entity.Admin;
import com.whoiszxl.entity.query.AdminQuery;
import com.whoiszxl.logger.annotation.SSLog;
import com.whoiszxl.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author whoiszxl
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员后台管理相关接口")
public class AdminController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;

    @SaCheckLogin
    @SaCheckPermission(value = {"admin:list"})
    @GetMapping("/list")
    @SSLog("管理员列表查询")
    @ApiOperation(value = "管理员列表查询", notes = "管理员列表查询", response = Admin.class)
    public ResponseResult<IPage<Admin>> list(AdminQuery query) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(query.getUsername())) {
            queryWrapper.eq(Admin::getUsername, query.getUsername());
        }
        if(StringUtils.isNotBlank(query.getMobile())) {
            queryWrapper.or().eq(Admin::getMobile, query.getMobile());
        }

        if(StringUtils.isNotBlank(query.getEmail())) {
            queryWrapper.or().eq(Admin::getEmail, query.getEmail());
        }

        IPage<Admin> pageResult = adminService.page(new Page<>(query.getPage(), query.getSize()), queryWrapper);
        return ResponseResult.buildSuccess(pageResult);
    }

    @SaCheckLogin
    @SaCheckPermission(value = {"admin:lockSwitch"})
    @PostMapping("/lock/switch/{username}")
    @SSLog("禁用or解禁管理员")
    @ApiOperation(value = "禁用or解禁管理员", notes = "禁用or解禁管理员", response = ResponseResult.class)
    public ResponseResult<Boolean> lockSwitch(@PathVariable String username) {
        Admin admin = adminService.getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, username));
        admin.setStatus(admin.getStatus() == 0 ? 1 : 0);
        boolean updateFlag = adminService.updateById(admin);
        return ResponseResult.buildByFlag(updateFlag);
    }

    @SaCheckLogin
    @SaCheckPermission(value = {"admin:adminInfo"})
    @PostMapping("/info")
    @SSLog("获取管理员用户信息")
    @ApiOperation(value = "获取管理员用户信息", notes = "获取管理员用户信息", response = Admin.class)
    public ResponseResult<Admin> adminInfo() {
        Integer adminId = StpUtil.getLoginIdAsInt();
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getId, adminId);
        Admin admin = adminService.getOne(queryWrapper);
        return ResponseResult.buildSuccess(admin);
    }
}

