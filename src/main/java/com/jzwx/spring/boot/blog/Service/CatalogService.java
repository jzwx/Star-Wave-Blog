package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Catalog;
import com.jzwx.spring.boot.blog.domain.User;

import java.util.List;

/**
 * CatalogService 分类服务接口
 *
 * @author jzwx
 * @version $ Id: CatalogService, v 0.1 2018/2/27 15:07 jzwx Exp $
 */
public interface CatalogService {
    /**
     * 保存Catalog
     * @param catalog
     * @return
     */
    Catalog saveCatalog(Catalog catalog);

    /**
     * 删除Catalog
     * @param id
     */
    void removeCatalog(Long id);

    /**
     * 根据id获取Catalog
     * @param id
     * @return
     */
    Catalog getCatalogById(Long id);

    /**
     * 获取Catalog列表 (因为个人博客分类不会很多所以返回的是个人博客下所有的分类)
     * @param user
     * @return
     */
    List<Catalog> listCatalogs(User user);
}
