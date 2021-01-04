package com.dhf.kitchen.system.pc.login.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.config.SessionContext;
import com.dhf.kitchen.shiro.JwtUtils;
import com.dhf.kitchen.system.pc.userdetail.mapper.UserDetailMapper;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.system.pc.login.mapper.UserMapper;
import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.dhf.kitchen.system.pc.login.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *  服务实现类
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Autowired
    private JwtUtils jwtUtils;

    /***
    　* 登录业务验证用户是否有效
    　* @param [user]
    　* @return com.dhf.esint_demo.base.KitResult
    　* @date 2020/11/14 8:09
    */
    @Override
    public KitResult queryByLoginPhone(User user) {

        User loginUser =  userMapper.queryByPhone(user);
        if (loginUser != null) {
            if (StringUtils.equals(user.getUserPass(),loginUser.getUserPass())) {
                return KitResult.succ(loginUser);
            }
            return KitResult.fail("密码不正确");
        }
        return KitResult.fail("用户不存在");
    }

    /**
    　* 注册用户
    　* @param [user]
    　* @return com.dhf.esint_demo.base.KitResult
    　* @date 2020/11/14 13:13
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public KitResult insertUser(User user) {
        String UUID = String.valueOf(java.util.UUID.randomUUID());
        User user1 = userMapper.queryByPhone(user);
        if (user1 == null) {
            user.setUserId(UUID);
            int insert = userMapper.insertUser(user);
            UserDetail userDetail = new UserDetail();
            BeanUtil.copyProperties(user,userDetail);
            userDetail.setId(UUID);
            userDetail.setCreateTime(new Date());
            int integer = userDetailMapper.insertUserDetail(userDetail);
            if (insert == 1 && integer == 1) {
                return KitResult.succ(user);
            }
        }
        return KitResult.fail("该手机号已被注册，请换一个手机号注册吧");
    }

    /***
    　* 修改用户密码  存回数据库
    　* @param [oldPass, newPass]
    　* @return com.dhf.esint_demo.base.KitResult
    　* @date 2020/11/14 13:14
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public KitResult changePass(String oldPass, String newPass) {
        User user = SessionContext.THREAD_LOCAL.get();
        if (user.getUserPass().equals(oldPass)) {
            user.setUserPass(newPass);
            userMapper.update(user,new QueryWrapper<User>()
                    .eq("user_phone",user.getUserPhone()));
            return KitResult.succ(user);
        } else {
            return KitResult.fail("原密码不正确");
        }


    }

    @Override
    public KitResult queryByPhone(User user) {

        User user1 = userMapper.queryByPhone(user);
        if (user1 == null) {
            return new KitResult("300",user.getUserPhone()+"该用户还不存在，请先注册");
        }
        return KitResult.succ(user1);
    }





}
