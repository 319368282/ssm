package com.jiangfx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangfx.entity.User;
import com.jiangfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户控制层类
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService pageService;

    /**
     * 分页查询
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public String pageList(ModelMap map,@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        Integer pageSize = 4;//每页显示记录数

        //分页查询
        /**
            PageHelper.startPage(pageNum, pageSize);
            `   pageNum ：当前页数
                pageSize ：一页大小
         */
        PageHelper.startPage(pageNo, pageSize);
        List<User> userList = pageService.list();//获取所有用户信息
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        map.addAttribute("pageInfo", pageInfo);

        return "list";
    }
}
