package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

// ==================== 自动登录请求 ====================
@Data
@ApiModel(description = "自动登录请求")
public class AutoLoginRequest {

    @ApiModelProperty(value = "刷新令牌", required = true, example = "eyJhbGciOi...")
    @NotBlank(message = "刷新令牌不能为空")
    private String refreshToken;
}