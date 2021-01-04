package com.dhf.kitchen.system.pc.userrelation.controller;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.userrelation.model.UserRelation;
import com.dhf.kitchen.system.pc.userrelation.service.UserRelationService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 10:09 2020/12/31
 * @Modified by
 */
@RestController
@RequiresAuthentication
@RequestMapping(value = "/attention")
public class UserRelationController {

    @Autowired
    private UserRelationService userRelationService;

    /**
    　* @Description 关注
    　* @Author 方万军
    　* [userRelation]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/31 10:16
    */
    @PostMapping(value = "/pop")
    public KitResult pop(@RequestBody UserRelation userRelation) {
        // 认为 "不是第一次关注"
        KitResult kitResult = userRelationService.insertFansNum(userRelation);
        if ("400".equals(kitResult.getCode())) {
            // 验证 "不是第一次关注" 失败
            return userRelationService.insertFirstFansNum(userRelation);
        }
        return kitResult;
    }

    /**
    　* @Description  取消关注
    　* @Author 方万军
    　* [userRelation]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/31 10:15
    */
    @PostMapping(value = "/push")
    public KitResult push(@RequestBody UserRelation userRelation) {
        return userRelationService.updateFansNum(userRelation);
    }

    /**
    　* @Description  查看两个用户之间的关系  "0" 我未关注他  "1" 我关注了他  "2" 互相关注
    　* @Author 方万军
    　* [userRelation]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/31 10:38
    */
    @PostMapping(value = "/getCode")
    public KitResult getCode(@RequestBody UserRelation userRelation) {
       return  userRelationService.getRelation(userRelation);
    }
}
