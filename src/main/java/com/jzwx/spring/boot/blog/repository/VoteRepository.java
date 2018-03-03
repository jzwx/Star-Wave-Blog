package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * VoteRepository 点赞仓储接口
 *
 * @author jzwx
 * @version $ Id: VoteRepository, v 0.1 2018/2/27 10:56 jzwx Exp $
 */
public interface VoteRepository extends JpaRepository<Vote,Long>{
}
