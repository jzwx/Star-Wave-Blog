package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Authority;
import com.jzwx.spring.boot.blog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AuthorityServiceImpl AuthorityService服务接口实现类
 *
 * @author jzwx
 * @version $ Id: AuthorityServiceImpl, v 0.1 2018/2/20 20:13 jzwx Exp $
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}
