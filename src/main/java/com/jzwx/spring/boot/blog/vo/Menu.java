package com.jzwx.spring.boot.blog.vo;

import java.io.Serializable;

/**
 * Menu 菜单值对象类
 *
 * @author jzwx
 * @version $ Id: Menu, v 0.1 2018/2/13 21:04 jzwx Exp $
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    private String            name;
    private String            url;

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
