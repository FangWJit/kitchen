package com.dhf.kitchen.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author : FangWanJun
 * @Date : created in 9:54 2020/11/18
 */
public class JwtToken implements AuthenticationToken {

    private String token;
    public JwtToken(String token) {
        this.token = token;
    }

    // 获取主要
    @Override
    public Object getPrincipal() {
        return token;
    }

    // 获取证书
    @Override
    public Object getCredentials() {
        return token;
    }
}
