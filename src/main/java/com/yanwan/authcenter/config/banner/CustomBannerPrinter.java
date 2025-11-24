package com.yanwan.authcenter.config.banner;

import lombok.extern.slf4j.Slf4j;
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


    @Override
    public void run(ApplicationArguments args) {
        // 如果配置为 false，不显示额外信息
        if (!authCenterProperties.getBanner()) {
            log.info("Banner display is disabled");
            return;
        }

        // 显示启动成功信息
        String separator = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

        System.out.println();
        System.out.println(separator);
        System.out.println(" ✅ " + authCenterProperties.getAppName() + " 启动成功！");
        System.out.println(" 📝 " + authCenterProperties.getDescription());
        System.out.println(" 👨‍💻 Author: " + authCenterProperties.getAuthor());
        System.out.println(" 🌐 Swagger UI: http://localhost:8080/doc.html");
        System.out.println(" 🔗 Health Check: http://localhost:8080/api/v1/system/health");
        System.out.println(separator);
        System.out.println();
    }
}