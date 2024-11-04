package top.wangxingyu.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author 笼中雀
 */

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class CustomFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //在请求处理之前，执行的逻辑
        log.info("请求前处理中");
        //将请求传递给下一个过滤器，或目标资源
        filterChain.doFilter(servletRequest, servletResponse);
        //在响应处理之后,执行的逻辑
        log.info("响应处理中");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter 初始化");
    }

    @Override
    public void destroy() {
        log.info("CustomFilter 销毁");
    }
}
