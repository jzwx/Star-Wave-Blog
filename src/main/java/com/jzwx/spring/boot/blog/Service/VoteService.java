package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Vote;

/**
 * VoteService 点赞服务接口
 *
 * @author jzwx
 * @version $ Id: VoteService, v 0.1 2018/2/27 10:59 jzwx Exp $
 */
public interface VoteService {
    /**
     * 根据id获取Vote
     * @param id
     * @return
     */
    Vote getVoteById(Long id);

    /**
     * 删除Vote
     * @param id
     */
    void removeVote(Long id);
}
