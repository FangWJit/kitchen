package com.dhf.kitchen.system.pc.userdetail.mapper;

import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhf.kitchen.system.pc.userdetail.model.dto.UserDetailDto;
import com.dhf.kitchen.system.pc.userdetail.model.dto.UserWorks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public interface UserDetailMapper extends BaseMapper<UserDetail> {

    // 查询用户的详情
    UserDetail queryUserDetail(String userId);
    // 插入用户的信息   用于注册新用户的时候 自动插入
    int insertUserDetail(UserDetail userDetail);
    // 获取用户排行
    List<UserDetail> getRank();
    // 更新用户的头像
    int updateUserPhoto(String photo,String id);
    // 获取用户的作品
    List<UserWorks> getWorks(@Param("userId") String userId);
    // 更新用户的信息
    int updateUser(UserDetail userDetail);
    // 获取用户的收藏夹
    List<UserWorks> getFavorites(@Param("userId") String userId);
    // 获取用户的历史观看记录  （最近三天以内的列表）
    List<UserWorks> getLately(@Param("userId") String userId);
}
