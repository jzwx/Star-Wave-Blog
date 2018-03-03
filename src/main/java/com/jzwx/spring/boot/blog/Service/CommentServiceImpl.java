package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Comment;
import com.jzwx.spring.boot.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommentServiceImpl 评论服务实现类
 *
 * @author jzwx
 * @version $ Id: CommentServiceImpl, v 0.1 2018/2/24 21:31 jzwx Exp $
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 根据id获取Comment
     * @param id
     * @return
     */
    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findOne(id);
    }

    /**
     * 删除评论
     * @param id
     */
    @Override
    public void removeComment(Long id) {
        commentRepository.delete(id);
    }
}
