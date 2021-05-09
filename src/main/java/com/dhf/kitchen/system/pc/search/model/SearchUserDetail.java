package com.dhf.kitchen.system.pc.search.model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public class SearchUserDetail implements Serializable {

private static final long serialVersionUID=1L;

    private String id;

    private String userPhone;

    private String userName;

    private Integer age;

    private String sex;

    private String userPhoto;
    /** 粉丝数 **/
    private Integer fans;
    /** 关注数 **/
    private Integer noricer;
    /** 作品数 **/
    private Integer notesNum;
    /** 收藏数 **/
    private Integer tuckNum;

    private Date createTime;

    private Date updateTime;


    public Integer getTuckNum() {
        return tuckNum;
    }

    public void setTuckNum(Integer tuckNum) {
        this.tuckNum = tuckNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getNoricer() {
        return noricer;
    }

    public void setNoricer(Integer noricer) {
        this.noricer = noricer;
    }

    public Integer getNotesNum() {
        return notesNum;
    }

    public void setNotesNum(Integer notesNum) {
        this.notesNum = notesNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", fans=" + fans +
                ", noricer=" + noricer +
                ", notesNum=" + notesNum +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
