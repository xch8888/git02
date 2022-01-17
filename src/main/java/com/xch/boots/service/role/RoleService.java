package com.xch.boots.service.role;

import com.xch.boots.mapper.role.RoleMapper;
import com.xch.boots.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.xch.boots.service.role
 * @ClassName: RoleService
 * @author: 清欢.
 * @date: 2022/1/9 20:39
 */

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    /**
     * 获取内容
     * @return 集合
     */
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }
}
