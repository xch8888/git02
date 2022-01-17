package com.xch.boots.mapper.role;

import com.xch.boots.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Connection;
import java.util.List;

/**
 * @package: com.xch.boots.mapper.role
 * @ClassName: RoleMapper
 * @author: 清欢.
 * @date: 2022/1/9 20:38
 */

@Mapper
public interface RoleMapper {

    /**
     * 获取内容
     * @return 集合
     */
    public List<Role> getRoleList();
}
