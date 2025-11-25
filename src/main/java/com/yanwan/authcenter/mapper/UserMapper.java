package com.yanwan.authcenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanwan.authcenter.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
