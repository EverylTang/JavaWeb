package com.pengzhen.cn.modules.sys.service;

import java.util.List;

import com.baomidou.framework.service.ISuperService;
import com.pengzhen.cn.commons.result.Tree;
import com.pengzhen.cn.modules.sys.entity.Resource;
import com.pengzhen.cn.modules.sys.entity.User;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends ISuperService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllTree();

    List<Tree> selectAllTrees();

    List<Tree> selectTree(User currentUser);

}