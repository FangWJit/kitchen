package com.dhf.kitchen.config;

import com.dhf.kitchen.system.pc.login.model.User;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 11:28 2020/12/1
 * @Modified by
 */
public class SessionContext {
    // 设置全局的 user
    public static final ThreadLocal<User> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(User user) {
        THREAD_LOCAL.set(user);
    }

    public static User get() {
      return  THREAD_LOCAL.get();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
