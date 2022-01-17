package com.xch.boots.mapper.user;

import com.xch.boots.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @package: com.xch.boots.mapper.user
 * @ClassName: UserMapper
 * @author: 清欢.
 * @date: 2022/1/8 21:28
 */

@Mapper
public interface UserMapper {
    /**
     * 登录
     * @param userCode 用户名
     * @param userPassword 密码
     * @return
     */
    public User getLogin(@Param("userCode") String userCode,@Param("userPassword") String userPassword);

    /**
     * 通过条件查询-userList
     * @param userName
     * @param userCode
     * @return
     * @throws Exception
     */
//    public List<User> getUserList(@Param("userName") String userName,
//                                  @Param("userCode") int userCode,
//                                  @Param("currentPageNo") int currentPageNo,
//                                  @Param("pageSize") int pageSize)throws Exception;

    /**
     * 查询用户表
     * @return 集合
     * @throws Exception
     */
//    public int getUserCount(@Param("userName") String userName, @Param("userRole") Integer userRole);

    /**
     * 根据id查询数据
     * @param id 用户id
     * @return
     */
    public User getUserById(@Param("id") Integer id);

    /**
     * 修改
     * @param user 对象
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据名字模糊查询
     * @param userName
     * @return
     */
    public List<User> getUserByName(@Param("userName") String userName);

    /**
     * 分页查询所有
     * @return
     */
    public List<User> selectUserByPage();

    /**
     * 删除
     * @param id 用户id
     * @return 受影响的行数
     */
    public int delUserById(@Param("id") Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);
}
