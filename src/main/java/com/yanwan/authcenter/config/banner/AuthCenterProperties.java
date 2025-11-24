package com.yanwan.authcenter.config.banner;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "auth-center")
public class AuthCenterProperties {

    /**
     * 是否显示 Banner
     * 默认: true
     */
    private Boolean banner = true;

    /**
     * 应用名称
     */
    private String appName = "Auth-Center";

    /**
     * 应用描述
     */
    private String description = "多架构统一鉴权服务";

    /**
     * 作者信息
     */
    private String author = "YanWan Team";
}












