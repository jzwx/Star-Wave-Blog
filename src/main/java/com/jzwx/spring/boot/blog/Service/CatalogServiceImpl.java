package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Catalog;
import com.jzwx.spring.boot.blog.domain.User;
import com.jzwx.spring.boot.blog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CatalogServiceImpl 分类服务接口实现类
 *
 * @author jzwx
 * @version $ Id: CatalogServiceImpl, v 0.1 2018/2/27 15:07 jzwx Exp $
 */
@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private CatalogRepository catalogRepository;

    /**
     * 保存Catalog
     * @param catalog
     * @return
     */
    @Override
    public Catalog saveCatalog(Catalog catalog) {
        //判断重复
        List<Catalog> list=catalogRepository.findByUserAndName(catalog.getUser(),catalog.getName());
        if(list!=null&&list.size()>0){
            throw new IllegalArgumentException("该分类已经存在了");
        }
        return catalogRepository.save(catalog);
    }

    /**
     * 删除Catalog
     * @param id
     */
    @Override
    public void removeCatalog(Long id) {
        catalogRepository.delete(id);
    }

    /**
     * 根据id获取Catalog
     * @param id
     * @return
     */
    @Override
    public Catalog getCatalogById(Long id) {
        return catalogRepository.findOne(id);
    }

    /**
     * 获取Catalog列表 (因为个人博客分类不会很多所以返回的是个人博客下所有的分类)
     * @param user
     * @return
     */
    @Override
    public List<Catalog> listCatalogs(User user) {
        return catalogRepository.findByUser(user);
    }
}
