package com.jzwx.spring.boot.blog.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Vote 实体类
 *
 * @author jzwx
 * @version $ Id: Vote, v 0.1 2018/2/27 10:08 jzwx Exp $
 */
@Entity //实体
public class Vote implements Serializable {
    private static final long serialVersionUID = 6476630636741247334L;

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long              id;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User              user;

    @Column(nullable = false) //映射为字段，值不能为空
    @org.hibernate.annotations.CreationTimestamp //由数据库自动创建时间
    private Timestamp         createTime;

    protected Vote() {

    }

    public Vote(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
