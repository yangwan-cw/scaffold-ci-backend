package com.yanwan.authcenter.commmon.mybatis;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatis-Plus 元数据自动填充处理器
 * 自动填充创建时间、更新时间、创建人、更新人等字段
 *
 * @author yanwan
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("开始插入填充...");

        // 填充创建时间
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());

        // 填充更新时间
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 填充创建人
        String userId = getCurrentUserId();
        this.strictInsertFill(metaObject, "createBy", String.class, userId);

        // 填充更新人
        this.strictInsertFill(metaObject, "updateBy", String.class, userId);
    }

    /**
     * 更新时自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("开始更新填充...");

        // 填充更新时间
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 填充更新人
        String userId = getCurrentUserId();
        this.strictUpdateFill(metaObject, "updateBy", String.class, userId);
    }

    /**
     * 获取当前登录用户ID
     */
    private String getCurrentUserId() {
        try {
            // 从 Sa-Token 中获取当前登录用户ID
            if (StpUtil.isLogin()) {
                Object loginId = StpUtil.getLoginId();
                return loginId != null ? loginId.toString() : "system";
            }
        } catch (Exception e) {
            log.debug("获取当前用户ID失败，使用默认值: {}", e.getMessage());
        }
        // 未登录或获取失败时，使用默认值
        return "system";
    }
}