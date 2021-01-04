package com.dhf.kitchen.system.pc.login.dto;

import com.dhf.kitchen.base.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author : FangWanJun
 * @Date : created in 14:51 2020/11/13
 */
@Getter
@Setter
@ApiModel(value = "用户登录信息")
public class UserInfoDto extends BaseDto {

    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "手机号不能为空")
    String userPhone;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    String userPass;

}
