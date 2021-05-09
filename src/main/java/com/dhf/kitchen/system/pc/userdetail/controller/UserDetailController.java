package com.dhf.kitchen.system.pc.userdetail.controller;


import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.userdetail.service.UserDetailService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/userDetail")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping(value = "/getDetail")
    @RequiresAuthentication
    public KitResult getDetail(String userId) {
        return userDetailService.queryUserDetail(userId);
    }

    /* 获取粉丝量前20 的用户 */
    @GetMapping(value = "/getUserRank")
    public KitResult getUserRank() {
        return userDetailService.getUserRank();
    }
}

