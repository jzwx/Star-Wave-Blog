package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CommentRepository 评论仓储接口
 *
 * @author jzwx
 * @version $ Id: CommentRepository, v 0.1 2018/2/24 21:28 jzwx Exp $
 */
public interface CommentRepository extends JpaRepository<Comment,Long>{
}
