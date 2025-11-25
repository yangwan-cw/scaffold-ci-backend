package com.yanwan.authcenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yanwan.authcenter.commmon.mybatis.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 *
 * @author yanwan
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@ApiModel(description = "用户实体")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "1001")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", example = "zhangsan")
    private String username;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", example = "张三", required = true)
    private String nickname;

    /**
     * 头像URL
     */
    @ApiModelProperty(value = "头像URL", example = "https://example.com/avatar.jpg")
    private String avatar;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", example = "zhangsan@example.com")
    private String email;

    /**
     * 状态: 0-禁用, 1-正常
     */
    @ApiModelProperty(value = "状态: 0-禁用, 1-正常", example = "1")
    private Integer status;

    /**
     * 注册方式
     */
    @ApiModelProperty(value = "注册方式: PHONE-手机号, WECHAT-微信, GITHUB-GitHub", example = "PHONE")
    private String registerType;
}