package com.dhf.kitchen.system.pc.login.dto;

import com.dhf.kitchen.base.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 11:41 2020/11/20
 * @Modified by
 */
@Getter
@Setter
@ApiModel(value = "忘记密码info")
public class AlterPassDto extends BaseDto {

    @ApiModelProperty(value = "手机号",required = true)
    @NotBlank(message = "电话不能为空")
    private String userPhone;

    @ApiModelProperty(value = "新密码",required = true)
    @NotBlank(message = "新密码不能为空")
    private String userPass;

}
