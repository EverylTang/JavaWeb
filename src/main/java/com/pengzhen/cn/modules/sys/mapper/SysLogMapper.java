package com.pengzhen.cn.modules.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.pengzhen.cn.modules.sys.entity.Role;
import com.pengzhen.cn.modules.sys.entity.SysLog;

/**
 *
 * SysLog 表数据库控制层接口
 *
 */
public interface SysLogMapper extends AutoMapper<SysLog> {

    List<Role> selectSysLogList(Pagination page);

}