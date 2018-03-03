package com.jzwx.spring.boot.blog.Service;

import com.jzwx.spring.boot.blog.domain.Vote;
import com.jzwx.spring.boot.blog.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * VoteServiceImpl 点赞服务接口实现类
 *
 * @author jzwx
 * @version $ Id: VoteServiceImpl, v 0.1 2018/2/27 11:01 jzwx Exp $
 */
@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    private VoteRepository voteRepository;

    /**
     * 根据id获取Vote
     * @param id
     * @return
     */
    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.findOne(id);
    }

    /**
     * 删除Vote
     * @param id
     */
    @Override
    public void removeVote(Long id) {
        voteRepository.delete(id);
    }
}
