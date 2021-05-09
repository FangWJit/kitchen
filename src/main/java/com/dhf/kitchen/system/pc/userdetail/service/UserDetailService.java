package com.dhf.kitchen.system.pc.userdetail.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public interface UserDetailService extends IService<UserDetail> {

    KitResult queryUserDetail(String userId);

    KitResult getUserRank();

    KitResult updateUserPhoto(String photo,String id);

    KitResult getWorks(String userId);

    KitResult updateUser(UserDetail userDetail);

}
