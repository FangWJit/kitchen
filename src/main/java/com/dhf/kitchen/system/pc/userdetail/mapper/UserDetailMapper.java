package com.dhf.kitchen.system.pc.userdetail.mapper;

import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    UserDetail queryUserDetail(String userId);

    int insertUserDetail(UserDetail userDetail);

    List<UserDetail> getRank();
}
