-- 用户主表
CREATE TABLE IF NOT EXISTS sys_user
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID（唯一标识）',
    username      VARCHAR(64) COMMENT '用户名',
    nickname      VARCHAR(64) NOT NULL COMMENT '用户昵称',
    avatar        VARCHAR(255) COMMENT '头像URL',
    email         VARCHAR(128) COMMENT '邮箱',
    status        TINYINT              DEFAULT 1 COMMENT '状态: 0-禁用, 1-正常',
    register_type VARCHAR(20) NOT NULL COMMENT '注册方式: PHONE-手机号, WECHAT-微信, GITHUB-GitHub',

    -- 审计字段
    create_by     VARCHAR(64) COMMENT '创建人',
    create_time   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by     VARCHAR(64) COMMENT '更新人',
    update_time   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    del_flag      TINYINT     NOT NULL DEFAULT 0 COMMENT '逻辑删除: 0-未删除, 1-已删除',
    -- 索引
    KEY idx_username (username),
    KEY idx_email (email),
    KEY idx_del_flag (del_flag)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户主表';