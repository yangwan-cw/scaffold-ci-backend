package com.yanwan.authcenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 版本信息 VO
 *
 * @author yanwan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("版本信息")
public class VersionVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("应用名称")
    private String appName;

    @ApiModelProperty("应用版本")
    private String version;

    @ApiModelProperty("Git 分支")
    private String gitBranch;

    @ApiModelProperty("Git Commit ID")
    private String gitCommitId;

    @ApiModelProperty("Git Commit ID (缩写)")
    private String gitCommitIdAbbrev;

    @ApiModelProperty("Git Commit 消息")
    private String gitCommitMessage;

    @ApiModelProperty("Git Commit 时间")
    private String gitCommitTime;

    @ApiModelProperty("Git 提交者")
    private String gitCommitUser;

    @ApiModelProperty("Git Tags")
    private String gitTags;

    @ApiModelProperty("构建时间")
    private String buildTime;

    @ApiModelProperty("构建用户")
    private String buildUser;

    @ApiModelProperty("构建主机")
    private String buildHost;

    @ApiModelProperty("Spring Boot 版本")
    private String springBootVersion;

    @ApiModelProperty("Java 版本")
    private String javaVersion;

    @ApiModelProperty("操作系统")
    private String osName;

    @ApiModelProperty("操作系统版本")
    private String osVersion;

    @ApiModelProperty("操作系统架构")
    private String osArch;
}