package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "切换账号请求")
public class SwitchAccountRequest {

    @ApiModelProperty(value = "账号ID", required = true, example = "123456")
    @NotBlank(message = "账号ID不能为空")
    private String accountId;
}