package com.yanwan.authcenter.version;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 自定义 Git 信息配置
 * 直接从 git.properties 文件读取
 *
 * @author yanwan
 */
@Slf4j
@Data
@Configuration
public class CustomGitProperties {

    private String branch;
    private String commitId;
    private String commitIdAbbrev;
    private String commitMessage;
    private String commitMessageShort;
    private String commitTime;
    private String commitUserName;
    private String commitUserEmail;
    private String tags;
    private String buildTime;
    private String buildUserName;
    private String buildHost;
    private String buildVersion;
    private Boolean dirty;

    @PostConstruct
    public void init() {
        loadGitProperties();
    }

    /**
     * 从 git.properties 文件加载属性
     */
    private void loadGitProperties() {
        try {
            ClassPathResource resource = new ClassPathResource("git.properties");

            if (!resource.exists()) {
                log.warn("git.properties 文件不存在");
                return;
            }

            Properties props = new Properties();
            try (InputStream is = resource.getInputStream()) {
                props.load(is);
            }

            // 读取属性（支持多种格式）
            this.branch = getProperty(props, "git.branch");
            this.commitId = getProperty(props, "git.commit.id", "git.commit.id.full");
            this.commitIdAbbrev = getProperty(props, "git.commit.id.abbrev");
            this.commitMessage = getProperty(props, "git.commit.message.full");
            this.commitMessageShort = getProperty(props, "git.commit.message.short");
            this.commitTime = getProperty(props, "git.commit.time");
            this.commitUserName = getProperty(props, "git.commit.user.name");
            this.commitUserEmail = getProperty(props, "git.commit.user.email");
            this.tags = getProperty(props, "git.tags");
            this.buildTime = getProperty(props, "git.build.time");
            this.buildUserName = getProperty(props, "git.build.user.name");
            this.buildHost = getProperty(props, "git.build.host");
            this.buildVersion = getProperty(props, "git.build.version");

            String dirtyStr = getProperty(props, "git.dirty");
            this.dirty = dirtyStr != null ? Boolean.valueOf(dirtyStr) : null;

            log.info("成功加载 Git 信息: branch={}, commitId={}", branch, commitIdAbbrev);

            // 打印所有加载的属性（调试用）
            log.debug("Git 属性详情: {}", this);

        } catch (IOException e) {
            log.error("加载 git.properties 失败", e);
        }
    }

    /**
     * 获取属性值（支持多个候选键）
     */
    private String getProperty(Properties props, String... keys) {
        for (String key : keys) {
            String value = props.getProperty(key);
            if (value != null && !value.trim().isEmpty()) {
                return value.trim();
            }
        }
        return null;
    }
}