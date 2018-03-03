package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.*;
import com.jzwx.spring.boot.blog.domain.es.EsBlog;
import com.jzwx.spring.boot.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * BlogServiceImpl 类
 *
 * @author jzwx
 * @version $ Id: BlogServiceImpl, v 0.1 2018/2/23 21:29 jzwx Exp $
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private EsBlogService esBlogService;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        boolean isNew = (blog.getId()==null);
        EsBlog esBlog = null;
        Blog returnBlog=blogRepository.save(blog);
        if(isNew){
            esBlog=new EsBlog(returnBlog);
        }else{
            esBlog=esBlogService.getEsBlogByBlogId(blog.getId());
            esBlog.update(returnBlog);
        }
        esBlogService.updateEsBlog(esBlog);
        return returnBlog;
    }

    @Transactional
    @Override
    public void removeBlog(Long id) {
        blogRepository.delete(id);
        EsBlog esBlog=esBlogService.getEsBlogByBlogId(id);//es中nosql数据库中的博客数据也进行删除
        esBlogService.removeEsBlog(esBlog.getId());
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, title, pageable);
        return blogs;
    }

    @Override
    public Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable) {
        //模糊查询
        title = "%" + title + "%";
        String tags = title;
        Page<Blog> blogs = blogRepository
            .findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(user, tags, pageable);
        return blogs;
    }

    @Override
    public void readingIncrease(Long id) {
        Blog blog = blogRepository.findOne(id);
        blog.setReadSize(blog.getReadSize() + 1);
        this.saveBlog(blog);
    }

    /**
     * 创建评论
     * @param blogId
     * @param commentContent
     * @return
     */
    @Override
    public Blog createComment(Long blogId, String commentContent) {
        Blog originalBlog = blogRepository.findOne(blogId);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取当前用户信息
        Comment comment = new Comment(user, commentContent);
        originalBlog.addComment(comment);
        return this.saveBlog(originalBlog);
    }

    /**
     * 删除评论
     * @param blogId
     * @param commentId
     */
    @Override
    public void removeComment(Long blogId, Long commentId) {
        Blog originalBlog = blogRepository.findOne(blogId);
        originalBlog.removeComment(commentId);
        this.saveBlog(originalBlog);
    }

    /**
     * 点赞
     * @param blogId
     * @return
     */
    @Override
    public Blog createVote(Long blogId) {
        Blog originalBlog = blogRepository.findOne(blogId);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Vote vote = new Vote(user);
        boolean isExist = originalBlog.addVote(vote);
        if(isExist){
            throw new IllegalArgumentException("该用户已经点过赞了");
        }
        return this.saveBlog(originalBlog);
    }

    /**
     * 取消点赞
     * @param blogId
     * @param voteId
     */
    @Override
    public void removeVote(Long blogId, Long voteId) {
        Blog originalBlog = blogRepository.findOne(blogId);
        originalBlog.removeVote(voteId);
        this.saveBlog(originalBlog);
    }

    /**
     * 根据分类进行查询
     * @param catalog
     * @param pageable
     * @return
     */
    @Override
    public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
        Page<Blog> blogs=blogRepository.findByCatalog(catalog,pageable);
        return blogs;
    }
}
