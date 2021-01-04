package com.dhf.kitchen.system.pc.login.mapper;

import com.dhf.kitchen.system.pc.login.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public interface UserMapper extends BaseMapper<User> {

    User queryByName(User user);

    User queryByPhone(User user);

    Integer insertUser(User user);

}
