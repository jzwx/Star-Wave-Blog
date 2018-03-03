package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AuthorityRepository 权限仓库接口
 *
 * @author jzwx
 * @version $ Id: AuthorityRepository, v 0.1 2018/2/20 20:09 jzwx Exp $
 */
public interface AuthorityRepository extends JpaRepository<Authority,Long>{
}
