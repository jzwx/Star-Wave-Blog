package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Authority;

/**
 * AuthorityService 服务接口
 *
 * @author jzwx
 * @version $ Id: AuthorityService, v 0.1 2018/2/20 20:10 jzwx Exp $
 */
public interface AuthorityService {

    /**
     * 根据id查询Authority
     * @param id
     * @return
     */
    Authority getAuthorityById(Long id);
}
