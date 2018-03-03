package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.User;
import com.jzwx.spring.boot.blog.domain.es.EsBlog;
import com.jzwx.spring.boot.blog.vo.TagVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * EsBlogService 博客全文搜索服务接口
 *
 * @author jzwx
 * @version $ Id: EsBlogService, v 0.1 2018/3/2 15:00 jzwx Exp $
 */
public interface EsBlogService {

    /**
     * 删除EsBlog
     * @param id
     */
    void removeEsBlog(String id);

    /**
     * 更新 EsBlog
     * @param esBlog
     * @return
     */
    EsBlog updateEsBlog(EsBlog esBlog);

    /**
     * 根据Blog的Id获取EsBlog
     * @param blogId
     * @return
     */
    EsBlog getEsBlogByBlogId(Long blogId);

    /**
     * 最新博客列表、分页
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable);

    /**
     * 最热博客列表、分页
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsBlog> listHotestEsBlogs(String keyword,Pageable pageable);

    /**
     * 博客列表、分页
     * @param pageable
     * @return
     */
    Page<EsBlog> listEsBlogs(Pageable pageable);

    /**
     * 最新前5
     * @return
     */
    List<EsBlog> listTop5NewestEsBlogs();

    /**
     * 最热前5
     * @return
     */
    List<EsBlog> listTop5HotestEsBlogs();

    /**
     * 最热前30标签
     * @return
     */
    List<TagVO> listTop30Tags();

    /**
     * 最热前12用户
     * @return
     */
    List<User> listTop12Users();
}
