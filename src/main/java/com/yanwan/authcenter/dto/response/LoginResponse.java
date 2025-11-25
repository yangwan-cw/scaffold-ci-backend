package com.yanwan.authcenter.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "登录响应")
public class LoginResponse {

    @ApiModelProperty(value = "访问令牌", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String accessToken;

    @ApiModelProperty(value = "刷新令牌", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String refreshToken;

    @ApiModelProperty(value = "令牌类型", example = "Bearer")
    private String tokenType;

    @ApiModelProperty(value = "过期时间（秒）", example = "7200")
    private Long expiresIn;

    @ApiModelProperty(value = "用户ID", example = "1001")
    private String userId;

    @ApiModelProperty(value = "用户昵称", example = "张三")
    private String nickname;

    @ApiModelProperty(value = "用户头像", example = "https://example.com/avatar.jpg")
    private String avatar;
}