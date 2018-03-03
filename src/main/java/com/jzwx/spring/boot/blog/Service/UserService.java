package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * UserService 用户服务接口
 *
 * @author jzwx
 * @version $ Id: UserService, v 0.1 2018/2/13 20:40 jzwx Exp $
 */
public interface UserService {
    /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 根据用户名集合，查询用户详情信息列表
     * @param usernames
     * @return
     */
    List<User> listUsersByUsernames(Collection<String> usernames);
}
