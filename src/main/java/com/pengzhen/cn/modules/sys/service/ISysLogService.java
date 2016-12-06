package com.pengzhen.cn.modules.sys.service;

import com.baomidou.framework.service.ISuperService;
import com.pengzhen.cn.commons.utils.PageInfo;
import com.pengzhen.cn.modules.sys.entity.SysLog;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends ISuperService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);


}