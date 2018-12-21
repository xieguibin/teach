package com.tt.teach.utils;

import com.tt.teach.pojo.Student;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;
 /**
   * @作者：解贵斌
   *@时间：2018/12/19  16:47
   *@描述：
  */
public class BaseController {
    //1.进行一个日志打印的管理
    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(BaseController.class);
    //2.常用的变量提取出来， 当道Base工具类中变为静态常量，方便使用
    protected static final String SESSION_KEY= "studentName";
    protected static final String FORWARD= "forward";
    protected    static final String REDIRECT= "redirect";
    //3.常用request，session，response的获取
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    public HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    public HttpSession getSession() {
        HttpSession session = getRequest().getSession();
        return session;
    }





}
