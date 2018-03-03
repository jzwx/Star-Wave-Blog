package com.jzwx.spring.boot.blog.util;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConstraintViolationExceptionHandler 异常处理器类
 *
 * @author jzwx
 * @version $ Id: ConstraintViolationExceptionHandler, v 0.1 2018/2/13 20:54 jzwx Exp $
 */
public class ConstraintViolationExceptionHandler {
    /**
     * 获取批量异常信息
     * @param e
     * @return
     */
    public static String getMessage(ConstraintViolationException e) {
        List<String> msgList = new ArrayList<String>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            msgList.add(constraintViolation.getMessage());
        }
        String messages= StringUtils.join(msgList.toArray(),";");
        return messages;
    }
}
