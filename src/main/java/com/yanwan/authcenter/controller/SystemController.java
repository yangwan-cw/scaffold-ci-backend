package com.yanwan.authcenter.controller;

import com.yanwan.authcenter.commmon.result.Result;
import com.yanwan.authcenter.version.GitInfo;
import com.yanwan.authcenter.vo.VersionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统信息控制器
 *
 * @author yanwan
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/system")
@Api(tags = "系统信息")
@RequiredArgsConstructor
public class SystemController {

    private final GitInfo gitInfo;

    @Value("${spring.application.name:auth-center}")
    private String appName;

    @Value("${project.version:1.0.0}")
    private String version;

    /**
     * 获取系统版本信息
     */
    @GetMapping("/version")
    @ApiOperation("获取系统版本信息")
    public Result<VersionVO> getVersion() {
        VersionVO versionVO = VersionVO.builder()
                // 应用信息
                .appName(appName)
                .version(version)
                // Git 信息
                .gitBranch(gitInfo.getBranch())
                .gitCommitId(gitInfo.getCommit().getId())
                .gitCommitIdAbbrev(gitInfo.getCommit().getIdAbbrev().getAbbrev())
                .gitCommitMessage(gitInfo.getCommit().getMessage().getShort_())
                .gitCommitTime(gitInfo.getCommit().getTime())
                .gitCommitUser(gitInfo.getCommit().getUser().getName())
                .gitTags(gitInfo.getTags())
                // 构建信息
                .buildTime(gitInfo.getBuild().getTime())
                .buildUser(gitInfo.getBuild().getUser().getName())
                .buildHost(gitInfo.getBuild().getHost())
                // 运行环境
                .springBootVersion(SpringBootVersion.getVersion())
                .javaVersion(System.getProperty("java.version"))
                .osName(System.getProperty("os.name"))
                .osVersion(System.getProperty("os.version"))
                .osArch(System.getProperty("os.arch"))
                .build();

        return Result.success(versionVO);
    }

    /**
     * 获取简单版本信息
     */
    @GetMapping("/version/simple")
    @ApiOperation("获取简单版本信息")
    public Result<String> getSimpleVersion() {
        String simpleVersion = String.format("%s v%s (commit: %s, branch: %s)",
                appName,
                version,
                gitInfo.getCommit().getIdAbbrev().getAbbrev(),
                gitInfo.getBranch());
        return Result.success(simpleVersion);
    }

    /**
     * 健康检查
     */
    @GetMapping("/health")
    @ApiOperation("健康检查")
    public Result<String> health() {
        return Result.success("OK");
    }
}