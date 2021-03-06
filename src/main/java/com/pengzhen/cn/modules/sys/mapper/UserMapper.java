package com.pengzhen.cn.modules.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.pengzhen.cn.modules.sys.entity.User;
import com.pengzhen.cn.modules.sys.entity.vo.UserVo;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends AutoMapper<User> {

    UserVo selectUserVoById(@Param("id") Long id);

    List<UserVo> selectUserVoPage(Pagination page, Map<String, Object> params);

}