package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "GitHub登录请求")
public class GithubLoginRequest {

    @ApiModelProperty(value = "GitHub授权码", required = true, example = "gho_abc123...")
    @NotBlank(message = "授权码不能为空")
    private String code;

    @ApiModelProperty(value = "回调地址", example = "http://localhost:3000/callback")
    private String redirectUri;
}