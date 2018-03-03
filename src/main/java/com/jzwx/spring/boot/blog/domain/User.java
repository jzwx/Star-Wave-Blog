package com.jzwx.spring.boot.blog.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User 实体类
 *
 * @author jzwx
 * @version $ Id: User, v 0.1 2018/1/28 14:13 jzwx Exp $
 */
@Entity //实体
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 9038255690191987381L;

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //数据库自增策略
    private Long              id;                                     // 实体唯一标识

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20) //映射字段，值不能为空
    private String            name;                                   //用户名

    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 50)
    @Email(message = "邮箱格式不对")
    @Column(nullable = false, length = 50, unique = true)
    private String            email;                                  //邮箱

    @NotEmpty(message = "账号不能为空")
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    private String            username;                               //账号

    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    @Column(length = 100)
    private String            password;                               //密码

    @Column(length = 200)
    private String            avatar;                                 //头像地址信息

    /**
     * 角色 权限 多对多关系
     */
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority>   authorities;

    protected User() { //无参构造函数;设置为protected防止直接使用
    }

    public User(Long id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 加密密码
     * @param password
     */
    public void setEncodePassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode(password);
        this.password = encodePasswd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d,name='%s',username='%s',email='%s']", id, name, username,
            email);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //需将List<Authority> 转成List<SimpleGrantedAuthority>.否则前端拿不到角色列表名称
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        for (GrantedAuthority authority : this.authorities) {
            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return simpleAuthorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    /**
     * 账号不过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *  账号是否未锁
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 验证信息是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账号未启用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
