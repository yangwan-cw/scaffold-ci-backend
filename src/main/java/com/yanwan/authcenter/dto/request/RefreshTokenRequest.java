package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "刷新令牌请求")
public class RefreshTokenRequest {

    @ApiModelProperty(value = "刷新令牌", required = true, example = "eyJhbGciOi...")
    @NotBlank(message = "刷新令牌不能为空")
    private String refreshToken;
}