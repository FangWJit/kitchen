package com.dhf.kitchen.system.pc.login.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public class User implements Serializable {

private static final long serialVersionUID=1L;

    @TableId
    private int id;
    /** 用户id **/
    private String userId;
    /** 用户昵称 **/
    private String userName;
    /** 用户密码 **/
    private String userPass;
    /** 用户电话 **/
    private String userPhone;
    /** 是否锁定 **/
    private Integer isLock;
    /** 密保问题 **/
    private String mibao_1;

    private String mibao_2;

    private String mibao_3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public String getMibao_1() {
        return mibao_1;
    }

    public void setMibao_1(String mibao_1) {
        this.mibao_1 = mibao_1;
    }

    public String getMibao_2() {
        return mibao_2;
    }

    public void setMibao_2(String mibao_2) {
        this.mibao_2 = mibao_2;
    }

    public String getMibao_3() {
        return mibao_3;
    }

    public void setMibao_3(String mibao_3) {
        this.mibao_3 = mibao_3;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", isLock=" + isLock +
                ", mibao_1='" + mibao_1 + '\'' +
                ", mibao_2='" + mibao_2 + '\'' +
                ", mibao_3='" + mibao_3 + '\'' +
                '}';
    }
}
