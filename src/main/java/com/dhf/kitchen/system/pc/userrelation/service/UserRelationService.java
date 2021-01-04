package com.dhf.kitchen.system.pc.userrelation.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.userrelation.model.UserRelation;

/**
 * @Author : 方万军
 * @Description  关注和取关
 * @Date : created in 9:57 2020/12/31
 * @Modified by
 */
public interface UserRelationService {


    /** 关注用户 **/
    KitResult insertFirstFansNum(UserRelation userRelation);

    /** 关注用户 **/
    KitResult insertFansNum(UserRelation userRelation);

    /** 取消关注 **/
    KitResult updateFansNum(UserRelation userRelation);

    /** 查询用户之间的关系 **/
    KitResult getRelation(UserRelation userRelation);

}
