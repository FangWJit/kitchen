package com.dhf.kitchen.system.pc.userdetail.model.dto;

import com.dhf.kitchen.base.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 9:47 2020/12/1
 * @Modified by
 */
@Setter
@Getter
@ApiModel(value = "用户详情")
public class UserDetailDto extends BaseDto {

    @ApiModelProperty(value = "序号")
    private Integer id;

    @ApiModelProperty(value = "用户电话")
    private String userPhone;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "用户头像")
    private String userPhoto;

    @ApiModelProperty(value = "用户粉丝")
    private Integer fans;

    @ApiModelProperty(value = "用户关注")
    private Integer noricer;

    @ApiModelProperty(value = "用户发布")
    private Integer notesNum;

    @ApiModelProperty(value = "用户创建时间")
    private Date createTime;

    @ApiModelProperty(value = "用户最后修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否为本人查看")
    private Boolean onlyRead = false;

    @Override
    public String toString() {
        return "UserDetailDto{" +
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
                ", onlyRead=" + onlyRead +
                '}';
    }
}
