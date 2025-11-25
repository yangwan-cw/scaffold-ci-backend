package com.yanwan.authcenter.controller;

import com.yanwan.authcenter.commmon.result.Result;
import com.yanwan.authcenter.version.CustomGitProperties;
import com.yanwan.authcenter.vo.VersionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统信息控制器（使用自定义 Git 信息）
 * 
 * @author yanwan
 */
@Slf4j
@Api(tags = "系统信息")
@RestController
@RequestMapping("/api/v1/system")
public class SystemController {

    @Value("${spring.application.name:unknown}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String version;

    // ⚠️ 使用自定义的 Git 信息配置
    @Resource
    private CustomGitProperties customGitProperties;

    @GetMapping("/version")
    @ApiOperation("获取系统版本信息")
    public Result<VersionVO> getVersion() {

        log.info("获取系统版本信息");
        log.debug("Git 信息: {}", customGitProperties);
        
        VersionVO versionVO = VersionVO.builder()
                // 应用信息
                .appName(appName)
                .version(version)
                // Git 信息（从自定义配置读取）
                .gitBranch(customGitProperties.getBranch())
                .gitCommitId(customGitProperties.getCommitId())
                .gitCommitIdAbbrev(customGitProperties.getCommitIdAbbrev())
                .gitCommitMessage(customGitProperties.getCommitMessageShort())
                .gitCommitTime(customGitProperties.getCommitTime())
                .gitCommitUser(customGitProperties.getCommitUserName())
                .gitTags(customGitProperties.getTags())
                // 构建信息
                .buildTime(customGitProperties.getBuildTime())
                .buildUser(customGitProperties.getBuildUserName())
                .buildHost(customGitProperties.getBuildHost())
                // 运行环境
                .springBootVersion(SpringBootVersion.getVersion())
                .javaVersion(System.getProperty("java.version"))
                .osName(System.getProperty("os.name"))
                .osVersion(System.getProperty("os.version"))
                .osArch(System.getProperty("os.arch"))
                .build();

        return Result.success(versionVO);
    }
}