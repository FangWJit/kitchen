package com.dhf.kitchen.system.pc.userrelation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhf.kitchen.system.pc.userrelation.model.UserRelation;

/**
 * @Author : 方万军
 * @Description   用户关系
 * @Date : created in 22:08 2020/12/20
 * @Modified by
 */
public interface UserRelationMapper extends BaseMapper<UserRelation> {

    /** 通过用户id查询关注数量 **/
    int selectNoricorNum(String userId);

    /** 通过用户id查询粉丝数量 **/
    int selectFansNum(String userId);

    /** 关注用户 **/
    int insertFirstFansNum(UserRelation userRelation);

    /** 关注用户 **/
    int insertFansNum(UserRelation userRelation);

    /** 取消关注 **/
    int updateFansNum(UserRelation userRelation);

    /** 查询用户之间的关系 **/
    int getRelation(UserRelation userRelation);
}
