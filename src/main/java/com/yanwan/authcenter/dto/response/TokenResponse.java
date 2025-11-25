package com.yanwan.authcenter.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "令牌信息响应")
public class TokenResponse {

    @ApiModelProperty(value = "当前令牌")
    private TokenInfo currentToken;

    @ApiModelProperty(value = "所有令牌列表")
    private List<TokenInfo> tokenList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(description = "令牌详情")
    public static class TokenInfo {

        @ApiModelProperty(value = "令牌ID", example = "token_123456")
        private String tokenId;

        @ApiModelProperty(value = "令牌值", example = "eyJhbGciOi...")
        private String token;

        @ApiModelProperty(value = "设备信息", example = "iPhone 13 Pro")
        private String device;

        @ApiModelProperty(value = "IP地址", example = "192.168.1.100")
        private String ipAddress;

        @ApiModelProperty(value = "创建时间", example = "2024-11-25 10:30:00")
        private String createTime;

        @ApiModelProperty(value = "最后使用时间", example = "2024-11-25 15:45:00")
        private String lastUseTime;

        @ApiModelProperty(value = "是否当前令牌", example = "true")
        private Boolean isCurrent;
    }
}