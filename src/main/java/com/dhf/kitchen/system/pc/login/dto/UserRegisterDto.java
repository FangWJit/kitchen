package com.dhf.kitchen.system.pc.login.dto;

import com.dhf.kitchen.base.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author : FangWanJun
 * @Date : created in 8:48 2020/11/14
 */
@Getter
@Setter
@ApiModel
public class UserRegisterDto extends BaseDto {

    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String userPass;

    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "手机号不能为空")
    private String userPhone;

    @ApiModelProperty(value = "密保问题1")
    private String mibao_1;

    @ApiModelProperty(value = "密保问题2")
    private String mibao_2;

    @ApiModelProperty(value = "密保问题3")
    private String mibao_3;
}
