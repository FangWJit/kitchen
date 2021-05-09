package com.dhf.kitchen.system.pc.userdetail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.userdetail.mapper.UserDetailMapper;
import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.dhf.kitchen.system.pc.userdetail.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 21:02 2020/12/1
 * @Modified by
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {

    @Autowired
    private UserDetailMapper userDetailMapper;

    /**
    　* @Description 查询用户的详细信息
    　* @Author 方万军
    　* [userId]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/6 15:30
    */
    @Override
    public KitResult queryUserDetail(String userId) {

        UserDetail userDetail = userDetailMapper.queryUserDetail(userId);
        if (userDetail == null) {
            return KitResult.fail("该用户未找到");
        }
        return KitResult.succ(userDetail);
    }

    /**
    　* @Description 用户排序
    　* @Author 方万军
    　* []
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/6 15:30
    */
    @Override
    public KitResult getUserRank() {
        List<UserDetail> rank = userDetailMapper.getRank();
        if (rank.size() == 0) return KitResult.fail("操作失败");
        return KitResult.succ(rank);
    }

}
