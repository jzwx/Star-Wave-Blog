package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Comment;

/**
 * CommentService 评论服务接口
 *
 * @author jzwx
 * @version $ Id: CommentService, v 0.1 2018/2/24 21:29 jzwx Exp $
 */
public interface CommentService {
    /**
     * 根据id获取Comment
     * @param id
     * @return
     */
    Comment getCommentById(Long id);

    /**
     * 删除评论
     * @param id
     */
    void removeComment(Long id);
}
