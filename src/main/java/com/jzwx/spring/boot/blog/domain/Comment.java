package com.jzwx.spring.boot.blog.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Comment 评论实体类
 *
 * @author jzwx
 * @version $ Id: Comment, v 0.1 2018/2/24 20:59 jzwx Exp $
 */
@Entity //实体
public class Comment implements Serializable {
    private static final long serialVersionUID = -3374992186748248537L;

    /**
     * 评论id
     */
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long              id;                                      //用户的唯一标识

    /**
     * 评论内容
     */
    @NotEmpty(message = "评论内容不能为空")
    @Size(min = 2, max = 500)
    @Column(nullable = false) //映射为字段，值不能为空
    private String            content;

    /**
     * 个人信息
     */
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User              user;

    /**
     * 评论创建时间
     */
    @Column(nullable = false) //映射为字段，值不能为空
    @org.hibernate.annotations.CreationTimestamp //由数据库自动创建时间
    private Timestamp         createTime;

    protected Comment() {

    }

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
