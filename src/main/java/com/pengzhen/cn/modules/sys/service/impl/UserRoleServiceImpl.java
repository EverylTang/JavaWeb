package com.pengzhen.cn.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.pengzhen.cn.modules.sys.entity.UserRole;
import com.pengzhen.cn.modules.sys.mapper.UserRoleMapper;
import com.pengzhen.cn.modules.sys.service.IUserRoleService;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends SuperServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}