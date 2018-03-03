package com.jzwx.spring.boot.blog.vo;

import com.jzwx.spring.boot.blog.domain.Catalog;

import java.io.Serializable;

/**
 * CatalogVO 类
 *
 * @author jzwx
 * @version $ Id: CatalogVO, v 0.1 2018/2/27 15:02 jzwx Exp $
 */
public class CatalogVO implements Serializable{
    private static final long serialVersionUID = -4451826914315048160L;

    private String username;

    private Catalog catalog;

    public CatalogVO(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
