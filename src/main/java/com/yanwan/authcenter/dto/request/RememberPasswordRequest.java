package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// ==================== 记住密码请求 ====================
@Data
@ApiModel(description = "记住密码请求")
public class RememberPasswordRequest {

    @ApiModelProperty(value = "是否记住", required = true, example = "true")
    private Boolean remember;

    @ApiModelProperty(value = "密码凭证", example = "encrypted_password_token")
    private String credential;
}
