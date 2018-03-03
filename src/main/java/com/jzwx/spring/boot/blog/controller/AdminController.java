package com.jzwx.spring.boot.blog.controller;

import com.jzwx.spring.boot.blog.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * AdminController 后台管理控制器类
 *
 * @author jzwx
 * @version $ Id: MainController, v 0.1 2018/2/12 13:01 jzwx Exp $
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    @GetMapping
    public ModelAndView listUsers(Model model){
        List<Menu> menuList=new ArrayList<Menu>();
        menuList.add(new Menu("用户管理","/users"));
        model.addAttribute("list",menuList);
        return new ModelAndView("/admins/index","model",model);
    }
}
