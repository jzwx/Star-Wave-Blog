package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.Catalog;
import com.jzwx.spring.boot.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * CatalogRepository 分类仓储接口
 *
 * @author jzwx
 * @version $ Id: CatalogRepository, v 0.1 2018/2/27 15:06 jzwx Exp $
 */
public interface CatalogRepository extends JpaRepository<Catalog,Long>{
    /**
     * 根据用户查询
     * @param user
     * @return
     */
    List<Catalog> findByUser(User user);

    /**
     * 根据用户和名称查询
     * @param user
     * @param name
     * @return
     */
    List<Catalog> findByUserAndName(User user,String name);
}
