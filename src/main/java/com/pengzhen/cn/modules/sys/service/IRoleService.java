package com.pengzhen.cn.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.framework.service.ISuperService;
import com.pengzhen.cn.commons.utils.PageInfo;
import com.pengzhen.cn.modules.sys.entity.Role;

/**
 *
 * Role 表数据服务层接口
 *
 */
public interface IRoleService extends ISuperService<Role> {

    List<Long> selectRoleIdListByUserId(Long userId);

    List<Map<Long, String>> selectRoleResourceListByRoleId(Long roleId);

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);

}