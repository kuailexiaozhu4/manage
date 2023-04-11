package com.zhu.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhu.manage.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
