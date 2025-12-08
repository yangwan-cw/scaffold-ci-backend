# springboot-auth-center

使用Spring Boot构建的集中身份验证服务，为您的应用程序提供安全的用户身份验证和授权。

## 分支架构说明

| 分支名称                          | 架构类型     | Spring Boot 版本 | Java版本 | 适用场景           | 说明                  |
|-------------------------------|----------|----------------|--------|----------------|---------------------|
| `main`                        | **单体架构** | **2.7.x**      | **8+** | **快速开发/中小型项目** | 默认分支，开箱即用，适合快速开发和学习 |
| `springboot-2.7-microservice` | 微服务架构    | 2.7.x          | 8+     | 大型分布式项目        | 服务拆分，独立部署，高可用       |
| `springboot-3.5-monolith`     | 单体架构     | 3.5.x          | 17+    | 新项目/现代化单体      | 支持最新特性，性能更优         |
| `springboot-3.5-microservice` | 微服务架构    | 3.5.x          | 17+    | 新项目/现代化微服务     | 最新技术栈，支持虚拟线程等新特性    |

## 模块

1. 用户模块： 核心数据表
2. 租户模块： 多租户管理
3. 魔法变量模块： 用于管理系统中的动态变量
4. 角色模块： 角色和权限管理
5. 登录日志模块：

多租户指的是: 支持多个租户（客户）在同一系统中独立运行和管理各自的数据和配置。

### 认证系统相关数据表

#### 用户相关

- sys_user：用户基本信息表
- sys_user_login_log：用户登录日志表
- sys_user_user_oauth：用户第三方登录关联表
- sys_user_role：用户角色关联表

#### 角色与权限相关

- sys_role：角色信息表
- sys_role_permission：角色权限关联表
- sys_permission：权限信息表
- sys_user_role: 用户角色关联表

#### 租户相关

- sys_tenant：租户信息表
- sys_tenant_application：租户应用表
- sys_tenant_oauth_config: 租户第三方登录配置表
- sys_tenant_login_config: 租户登录配置表

### 特性

- 支持单体和微服务架构
- 集成 MySQL 和 Redis
- 支持多租户
- 完善的用户和角色管理
- 丰富的 API 文档（Swagger / Knife4j 支持）
- 日志记录和审计功能
- 易于扩展和定制
- 可拔插三方登录（OAuth2.0）
- 支持 Spring Boot 2.7.x 和 3.5.x

## 快速开始

### 环境要求

| 组件    | 版本要求                                         | 备注       |
|-------|----------------------------------------------|----------|
| JDK   | 8+ (Spring Boot 2.7) / 17+ (Spring Boot 3.5) | 必须       |
| Maven | 3.6+                                         | 必须       |
| MySQL | 8.0+                                         | 必须       |
| Redis | 6.0+                                         | 必须       |
| Nacos | 2.2+                                         | 仅微服务架构需要 |

### 单体架构部署（main 分支 - 推荐入门）

```bash
# 1. 克隆项目（默认就是 main 分支）
git clone <repository-url>
cd auth-cli

# 2. 修改配置文件
vim src/main/resources/application.yml
# 配置数据库、Redis连接信息

# 3. 初始化数据库
mysql -u root -p < docs/sql/schema.sql

# 4. 编译打包
mvn clean package -DskipTests

# 5. 运行应用
java -jar target/auth-cli-1.0.0.jar

# 6. 访问接口文档
# http://localhost:8080/doc.html
```

### Spring Boot 3.5 单体架构部署

```bash
# 1. 克隆项目
git clone <repository-url>
cd auth-cli

# 2. 切换到 Spring Boot 3.5 单体分支
git checkout springboot-3.5-monolith

# 3. 确保 JDK 17+
java -version

# 4. 修改配置文件
vim src/main/resources/application.yml

# 5. 初始化数据库
mysql -u root -p < docs/sql/schema.sql

# 6. 编译打包
mvn clean package -DskipTests

# 7. 运行应用
java -jar target/auth-cli-1.0.0.jar
```

## 开发规范

## 详细文档

博客: [inspirex-项目](https://your-blog-url.com)

github: [github](https://github.com/yangwan-cw)

