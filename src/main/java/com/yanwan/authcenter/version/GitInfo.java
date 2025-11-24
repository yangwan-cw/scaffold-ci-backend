package com.yanwan.authcenter.version;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 版本信息配置类
 * 从 git.properties 文件中读取 Git 信息
 *
 * @author yanwan
 */
@Data
@Component
@ConfigurationProperties(prefix = "git")
public class GitInfo {

    /**
     * Git 分支
     */
    private String branch;

    /**
     * Git commit ID (完整)
     */
    private Commit commit = new Commit();

    /**
     * Git 构建信息
     */
    private Build build = new Build();

    /**
     * 是否脏数据（有未提交的修改）
     */
    private Boolean dirty;

    /**
     * Git Tags
     */
    private String tags;

    @Data
    public static class Commit {
        /**
         * Commit ID (完整)
         */
        private String id;

        /**
         * Commit ID (缩写，7位)
         */
        private Id idAbbrev = new Id();

        /**
         * Commit 消息
         */
        private Message message = new Message();

        /**
         * Commit 时间
         */
        private String time;

        /**
         * 提交者信息
         */
        private User user = new User();

        @Data
        public static class Id {
            /**
             * 缩写的 commit ID
             */
            private String abbrev;
        }

        @Data
        public static class Message {
            /**
             * 完整的 commit 消息
             */
            private String full;

            /**
             * 简短的 commit 消息
             */
            private String short_;
        }

        @Data
        public static class User {
            /**
             * 提交者邮箱
             */
            private String email;

            /**
             * 提交者名称
             */
            private String name;
        }
    }

    @Data
    public static class Build {
        /**
         * 构建时间
         */
        private String time;

        /**
         * 构建版本
         */
        private String version;

        /**
         * 构建主机
         */
        private String host;

        /**
         * 构建用户
         */
        private User user = new User();

        @Data
        public static class User {
            /**
             * 构建用户名
             */
            private String name;

            /**
             * 构建用户邮箱
             */
            private String email;
        }
    }
}