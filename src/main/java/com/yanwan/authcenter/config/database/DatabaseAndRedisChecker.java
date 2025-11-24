package com.yanwan.authcenter.config.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Component
@AllArgsConstructor
public class DatabaseAndRedisChecker implements CommandLineRunner {

    private final DataSource dataSource;
    private final RedisTemplate<String, Object> redisTemplate;


    @Override
    public void run(String... args) {
        checkMySQL();
        checkRedis();
    }

    private void checkMySQL() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(2)) { // 2秒超时
                log.info("MySQL 连接正常");
            } else {
                log.error("MySQL 连接无效");
            }
        } catch (SQLException e) {
            log.error(" MySQL 连接失败: {}", e.getMessage(), e);
        }
    }

    private void checkRedis() {
        try {
            String pong = redisTemplate.getConnectionFactory().getConnection().ping();
            if ("PONG".equalsIgnoreCase(pong)) {
                log.info("Redis 连接正常");
            } else {
                log.error("Redis 连接异常，返回值: {}", pong);
            }
        } catch (Exception e) {
            log.error(" Redis 连接失败: {}", e.getMessage(), e);
        }
    }
}
