package com.jzwx.spring.boot.blog.vo;

import java.io.Serializable;

/**
 * TageVO tags值类
 *
 * @author jzwx
 * @version $ Id: TageVO, v 0.1 2018/3/2 14:57 jzwx Exp $
 */
public class TagVO implements Serializable {
    private static final long serialVersionUID = -7768902253044026997L;

    private String            name;

    private Long              count;

    public TagVO(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
