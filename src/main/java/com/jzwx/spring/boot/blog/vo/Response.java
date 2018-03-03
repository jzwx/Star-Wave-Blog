package com.jzwx.spring.boot.blog.vo;

/**
 * Response 返回对象类
 *
 * @author jzwx
 * @version $ Id: Response, v 0.1 2018/2/13 20:49 jzwx Exp $
 */
public class Response {
    private boolean success; //处理是否成功
    private String  message; //处理后消息提示
    private Object  body;    //返回数据

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}
