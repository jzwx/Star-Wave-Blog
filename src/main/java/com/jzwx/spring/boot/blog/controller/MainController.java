package com.jzwx.spring.boot.blog.controller;

import com.jzwx.spring.boot.blog.Service.AuthorityService;
import com.jzwx.spring.boot.blog.Service.UserService;
import com.jzwx.spring.boot.blog.domain.Authority;
import com.jzwx.spring.boot.blog.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * MainController 主页控制类
 *
 * @author jzwx
 * @version $ Id: MainController, v 0.1 2018/2/12 13:01 jzwx Exp $
 */
@Controller
public class MainController {

    /**
     * 日志打印器
     * */
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;//普通用户博主id

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/blogs";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败用户名或密码错误!");
        return "login";
    }

    /**
     * 注册页面初始化
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 用户注册功能
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        userService.registerUser(user);
        return "redirect:/login";
    }

    /**
     * 用户搜索
     *
     * @return
     */
    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
