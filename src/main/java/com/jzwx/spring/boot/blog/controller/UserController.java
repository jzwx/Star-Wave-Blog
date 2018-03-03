package com.jzwx.spring.boot.blog.controller;

import com.jzwx.spring.boot.blog.Service.AuthorityService;
import com.jzwx.spring.boot.blog.Service.UserService;
import com.jzwx.spring.boot.blog.domain.Authority;
import com.jzwx.spring.boot.blog.domain.User;
import com.jzwx.spring.boot.blog.util.ConstraintViolationExceptionHandler;
import com.jzwx.spring.boot.blog.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserController 类
 *
 * @author jzwx
 * @version $ Id: UserController, v 0.1 2018/1/31 19:30 jzwx Exp $
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 用户服务接口
     */
    @Autowired
    private UserService userService;

    /**
     * 权限服务接口
     */
    @Autowired
    private AuthorityService authorityService;

    /**
     * 查询所有用户
     *
     * @param async
     * @param pageIndex
     * @param pageSize
     * @param name
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value = "async", required = false) boolean async,
                             @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                             @RequestParam(value = "name", required = false, defaultValue = "") String name,
                             Model model) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<User> page = userService.listUsersByNameLike(name, pageable);
        List<User> list = page.getContent();//当前所在页面数据列表
        model.addAttribute("page", page);
        model.addAttribute("userList", list);
        model.addAttribute("title", "用户管理");
        return new ModelAndView(async == true ? "users/list::#mainContainerRepleace" : "users/list", "userModel", model);
    }

    /**
     * 查询用户详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户详情");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取 form 表单页面
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null, null, null, null));
        return new ModelAndView("users/add", "userModel", model);
    }

    /**
     * 保存或者修改用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> saveOrUpdateUser(User user, Long authorityId) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(authorityId));
        user.setAuthorities(authorities);
        try {
            userService.saveOrUpdateUser(user);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }
        return ResponseEntity.ok().body(new Response(true,"处理成功",user));
    }

    /**
     * 删除用户信息页面
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id, Model model) {
        try {
            userService.removeUser(id);
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(false, e.getMessage()));
        }
        return ResponseEntity.ok().body(new Response(true, "处理成功"));//重定向到list页面
    }

    /**
     * 获取修改用户的界面，及数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/edit", "userModel", model);
    }
}
