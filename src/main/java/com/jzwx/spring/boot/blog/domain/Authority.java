package com.jzwx.spring.boot.blog.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Authority 权限实体类
 *
 * @author jzwx
 * @version $ Id: TestAuthority, v 0.1 2018/2/20 21:41 jzwx Exp $
 */
@Entity
public class Authority implements GrantedAuthority {
    private static final long serialVersionUID = -9095654476789768244L;
    /**
     * 权限id
     */
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长策略
    private Long id;

    /**
     * 角色（权限）名称
     */
    @Column(nullable = false)//映射为字段，值不能为空
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
