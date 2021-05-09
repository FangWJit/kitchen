package com.dhf.kitchen.system.pc.userdetail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.userdetail.mapper.UserDetailMapper;
import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.dhf.kitchen.system.pc.userdetail.model.dto.UserWorks;
import com.dhf.kitchen.system.pc.userdetail.service.UserDetailService;
import com.dhf.kitchen.system.pc.word.mapper.WordMapper;
import com.dhf.kitchen.system.pc.word.model.dto.WordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private WordMapper wordMapper;

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

    /**
     *    修改图片
     * @param photo
     * @param id
     * @return
     */
    @Override
    public KitResult updateUserPhoto(String photo, String id) {
        int i = userDetailMapper.updateUserPhoto(photo, id);
        if (i<0) return KitResult.fail("头像修改失败");
        return KitResult.succ(null);
    }

    // 获取用户的所有作品
    @Override
    public KitResult getWorks(String userId) {
        Map<String,Object> map = new HashMap<>();
        List<UserWorks> FoodList = userDetailMapper.getWorks(userId);
        List<WordDto> userWordList = wordMapper.getUserWordList(userId);
        if (FoodList.size() == 0 && userWordList.size() == 0) return KitResult.fail("没有发布任何作品");
        map.put("FoodList",FoodList);
        map.put("userWordList",userWordList);
        return KitResult.succ(map);
    }

    @Override
    public KitResult updateUser(UserDetail userDetail) {
        int i = userDetailMapper.updateUser(userDetail);
        if (i == -1) return KitResult.fail("更新失败");
        return KitResult.succ(null);
    }

}
