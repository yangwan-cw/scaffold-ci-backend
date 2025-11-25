package com.yanwan.authcenter.config.banner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@Order(1)
public class CustomBannerPrinter implements ApplicationRunner {

    @Resource
    private AuthCenterProperties authCenterProperties;

    // 读取 server.port，默认 8080
    @Value("${server.port:8080}")
    private int serverPort;

    // 读取 server.servlet.context-path，默认空
    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Override
    public void run(ApplicationArguments args) {
        if (!authCenterProperties.getBanner()) {
            log.info("Banner display is disabled");
            return;
        }

        String baseUrl = "http://localhost:" + serverPort + contextPath;

        String separator = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

        System.out.println();
        System.out.println(separator);
        System.out.println(" " + authCenterProperties.getAppName() + " 启动成功！");
        System.out.println(" " + authCenterProperties.getDescription());
        System.out.println(" Author: " + authCenterProperties.getAuthor());
        System.out.println(" Druid Monitor:  " + baseUrl + "/druid/");
        System.out.println(" Swagger UI: " + baseUrl + "/doc.html");
        System.out.println(" Health Check: " + baseUrl + "/api/v1/system/health");
        System.out.println(separator);
        System.out.println();
    }
}
