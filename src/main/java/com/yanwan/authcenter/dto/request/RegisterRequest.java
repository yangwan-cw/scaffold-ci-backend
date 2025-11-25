package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "用户注册请求")
public class RegisterRequest {

    @ApiModelProperty(value = "手机号", required = true, example = "13800138000")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "验证码", required = true, example = "123456")
    @NotBlank(message = "验证码不能为空")
    private String code;

    @ApiModelProperty(value = "密码", required = true, example = "123456")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户昵称", example = "张三")
    private String nickname;
}