package com.xch.boots.controller;

import com.github.pagehelper.PageInfo;
import com.xch.boots.pojo.Role;
import com.xch.boots.pojo.User;
import com.xch.boots.service.role.RoleService;
import com.xch.boots.service.user.UserService;
import com.xch.boots.tools.PageSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.xch.boots.controller
 * @ClassName: IndexController
 * @author: 清欢.
 * @date: 2022/1/6 14:50
 */

@Slf4j
@Controller
public class IndexController {

    @Resource
    UserService userService;

    /**
     * 进去登录页面
     * @return
     */
    @GetMapping("/login")
    public String LoginPage(){
        return "login";
    }

    /**
     * 登录处理
     * @return
     */
    @PostMapping("/login")
    public String toLogin(@RequestParam("userCode") String userCode,
                          @RequestParam("userPassword") String userPassword,
                          HttpSession session,
                          Model model){
        User user=userService.getLogin(userCode,userPassword);
        log.info("数据:"+user);
        if(user!=null){
            //写入session
            session.setAttribute("loginUser",user);
            //登录成功
            return "redirect:/main.html";
        }else {
            model.addAttribute("error","用户名或者密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mains(HttpSession session,Model model){
//        Object loginUser=session.getAttribute("loginUser");
//        if(loginUser!=null){
            return "main";
//        }else {
//            model.addAttribute("error","请先登录");
//            return "login";
//        }
    }

    @GetMapping("/userList")
    public String getAllList(){
//        model.addAttribute("list",userService.getListByName(null));
        return "user";
    }

//    @PostMapping("/userList")
//    public String toList(@RequestParam(value = "userName",required = false) String userName,Model model){
//        model.addAttribute("list",userService.getListByName(userName));
//        return "user";
//    }


    @ResponseBody
    @GetMapping("/testPageHelper1")
    public PageInfo<User> testPageHelper1(@RequestParam(defaultValue = "1")Integer currentPage,
                                          @RequestParam(defaultValue = "5")Integer pageSize){
        PageInfo<User> queryResult=userService.findAllUserByPages(currentPage,pageSize);
        return queryResult;
    }

    @ResponseBody
    @PostMapping("/testPageHelper2")
    public List<User> testPageHelper2(){
        List<User> queryResult=userService.findAllUserByPageF(2,5);
        return queryResult;
    }

    @ResponseBody
    @GetMapping("/delUser")
    public Map delUser(@RequestParam("id") Integer id){
        boolean b = userService.delUserById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("flag",b);
        return map;
    }

    @GetMapping("/upduser")
    public String edit(){
        return "updateUser";
    }

    @ResponseBody
    @PostMapping("/getUserById")
    public User getUserById(@RequestParam("id") Integer id){
        User user=userService.getUserById(id);
       return user;
    }

    @ResponseBody
    @PostMapping("/updateUser")
    public Map updateUser(User user){
        boolean b = userService.updateUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("flag",b);
        return map;
    }

    /**
     * 进入添加页面
     * @return
     */
    @GetMapping("/uadd")
    public String addUser(){
        return "uadd";
    }

    @ResponseBody
    @PostMapping("/addUser")
    public Map saveUser(User user){
        boolean b= userService.addUser(user);
        Map<String,Object> map=new HashMap<>();
        map.put("flag",b);
        return map;
    }

}
