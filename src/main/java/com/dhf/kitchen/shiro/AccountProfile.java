package com.dhf.kitchen.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author : FangWanJun
 * @Date : created in 10:32 2020/11/18
 */
@Data
public class AccountProfile implements Serializable {

    private String userName;
    private String userPass;
    private String userPhone;
}
