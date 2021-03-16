package com.dhf.kitchen.system.pc.userrelation.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 22:03 2020/12/20
 * @Modified by
 */
@Getter
@Setter
public class UserRelation implements Serializable {

    @TableId
    private int id;
    /** 操作的id **/
    private String userId;
    /** 关注的id **/
    private String noricorId;


}
