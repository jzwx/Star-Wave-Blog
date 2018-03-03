package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.Blog;
import com.jzwx.spring.boot.blog.domain.Catalog;
import com.jzwx.spring.boot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BlogRepository 博客仓储接口
 *
 * @author jzwx
 * @version $ Id: BlogRepository, v 0.1 2018/2/23 21:12 jzwx Exp $
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
    /**
     * 根据用户名、博客标题分页查询博客列表
     * @param user
     * @param title
     * @param pageable
     * @return
     */
    Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);

    /**
     * 根据用户名、博客标题、标签查询博客列表（时间逆序）
     * @param title
     * @param user
     * @param pageable
     * @return
     */
    Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(User user, String title,Pageable pageable);

    /**
     * 根据分类查询博客列表
     * @param catalog
     * @param pageable
     * @return
     */
    Page<Blog> findByCatalog(Catalog catalog,Pageable pageable);
}
