package com.pengzhen.cn.modules.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.pengzhen.cn.modules.sys.entity.Organization;

/**
 *
 * Organization 表数据库控制层接口
 *
 */
public interface OrganizationMapper extends AutoMapper<Organization> {

    List<Organization> selectByPIdNull();

    List<Organization> selectAllByPId(@Param("pId") Long pid);

    List<Organization> selectAll();

}