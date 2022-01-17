package com.xch.boots.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xch.boots.mapper.user.UserMapper;
import com.xch.boots.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.xch.boots.service.user
 * @ClassName: UserService
 * @author: 清欢.
 * @date: 2022/1/8 21:34
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public User getLogin(String userCode,String userPassword){
        User user=userMapper.getLogin(userCode,userPassword);
        return user;
    }

    /**
     * 通过条件查询-userList
     * @param userName
     * @param userCode
     * @return
     * @throws Exception
     */
//    public List<User> getUserList(String userName, int userCode, int currentPageNo, int pageSize){
//        List<User> list=new ArrayList<>();
//        try {
//            list=userMapper.getUserList(userName,userCode,currentPageNo,pageSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    /**
     * 查询用户表
     * @return 集合
     * @throws Exception
     */
//    public int getUserCount(String userName,Integer userRole) {
//            return userMapper.getUserCount(userName, userRole);
//    }

    public List<User> getListByName(String userName){
        return userMapper.getUserByName(userName);
    }


    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest){
        int pageNum=pageRequest.getPageNumber();
        int pageSize=pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<User> sysMenus=userMapper.selectUserByPage();
        return new PageInfo<User>(sysMenus);
    }

    public List<User> findAllUserByPageF(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> lists=userMapper.selectUserByPage();
        return lists;
    }

    public PageInfo<User> findAllUserByPages(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> lists=userMapper.selectUserByPage();
        PageInfo<User> pageInfo=new PageInfo<User>(lists);
        return pageInfo;
    }

    public boolean delUserById(Integer id){
        boolean flag=false;
        if(userMapper.delUserById(id)>0){
            flag=true;
        }
        return flag;
    }

    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    public boolean updateUser(User user){
        boolean flag=false;
        if(userMapper.updateUser(user)>0){
            flag=true;
        }
        return flag;
    }

    public boolean addUser(User user){
        boolean flag=false;
        if(userMapper.addUser(user)>0){
            flag=true;
        }
        return flag;
    }
}
