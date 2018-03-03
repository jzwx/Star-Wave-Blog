package com.jzwx.spring.boot.blog.repository.es;

import com.jzwx.spring.boot.blog.domain.Blog;
import com.jzwx.spring.boot.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlogRepository 全文搜索仓储接口
 *
 * @author jzwx
 * @version $ Id: EsBlogRepository, v 0.1 2018/3/2 14:49 jzwx Exp $
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 模糊查询（去重复）
     * @param title
     * @param summary
     * @param content
     * @param tags
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(String title,
                                                                                                            String summary,
                                                                                                            String content,
                                                                                                            String tags,
                                                                                                            Pageable pageable);

    /**
     * 根据博客的id查询EsBlog
     * @param blogId
     * @return
     */
    EsBlog findByBlogId(Long blogId);
}
