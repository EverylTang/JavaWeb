package com.pengzhen.cn.modules.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.pengzhen.cn.modules.sys.entity.Resource;

/**
 *
 * Resource 表数据库控制层接口
 *
 */
public interface ResourceMapper extends AutoMapper<Resource> {

    List<Resource> selectAllByTypeAndPIdNull(@Param("resourceType")Integer resourceType);

    List<Resource> selectAllByTypeAndPId(@Param("resourceType")Integer resourceType, @Param("pId")Long pId);

    List<Resource> selectAll();

}