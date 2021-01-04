package com.dhf.kitchen.system.pc.userrelation.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.userrelation.mapper.UserRelationMapper;
import com.dhf.kitchen.system.pc.userrelation.model.UserRelation;
import com.dhf.kitchen.system.pc.userrelation.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 9:58 2020/12/31
 * @Modified by
 */
@Service
public class UserRelationServiceImpl implements UserRelationService {

    @Autowired
    private UserRelationMapper userRelationMapper;

    @Override
    public KitResult insertFirstFansNum(UserRelation userRelation) {
        int i = userRelationMapper.insertFirstFansNum(userRelation);
        if (i ==0 ) return KitResult.fail("关注失败");
        return KitResult.succ(1);
    }

    @Override
    public KitResult insertFansNum(UserRelation userRelation) {
        int i = userRelationMapper.insertFansNum(userRelation);
        if (i == 0) return KitResult.fail("关注失败");
        return KitResult.succ(2);
    }

    @Override
    public KitResult updateFansNum(UserRelation userRelation) {
        int i = userRelationMapper.updateFansNum(userRelation);
        if (i == 0) return KitResult.fail("取关失败");
        return KitResult.succ(3);
    }

    @Override
    public KitResult getRelation(UserRelation userRelation) {

        int relation = userRelationMapper.getRelation(userRelation);
        // 我还未关注
        if (relation == 0) return KitResult.succ(0);
        // 查看他对我的状态
        UserRelation u = new UserRelation();
        u.setUserId(userRelation.getNoricorId());
        u.setNoricorId(userRelation.getUserId());

        int relation1 = userRelationMapper.getRelation(u);

        if (relation == 1 && relation1 == 1)
            // 互相关注
            return KitResult.succ(2);
        // 仅我关注
        return KitResult.succ(1);
    }


}
