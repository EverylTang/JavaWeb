package com.pengzhen.cn.modules.sys.service;

import java.util.List;

import com.baomidou.framework.service.ISuperService;
import com.pengzhen.cn.commons.result.Tree;
import com.pengzhen.cn.modules.sys.entity.Organization;

/**
 *
 * Organization 表数据服务层接口
 *
 */
public interface IOrganizationService extends ISuperService<Organization> {

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();

}