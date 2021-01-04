package com.dhf.kitchen.system.pc.login.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.login.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public interface UserService extends IService<User> {

    KitResult queryByLoginPhone(User user);

    KitResult insertUser(User user);

    KitResult changePass(String oldPass, String newPass);

    KitResult queryByPhone(User user);


}
