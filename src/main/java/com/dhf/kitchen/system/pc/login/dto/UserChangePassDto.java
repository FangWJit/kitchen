package com.dhf.kitchen.system.pc.login.dto;

import com.dhf.kitchen.base.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author : FangWanJun
 * @Date : created in 10:29 2020/11/14
 */
@Getter
@Setter
@ApiModel(value = "修改密码")
public class UserChangePassDto extends BaseDto {

    @NotBlank(message = "原密码不能为空")
    @ApiModelProperty(value = "原密码", required = true)
    private String userPass;

    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码", required = true)
    private String newUserPass;

}
