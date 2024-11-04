package top.wangxingyu.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


/**
 * @author 笼中雀
 */
@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("AuthFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String authToken=request.getHeader("Authorization");

        //是匹配的授权令牌
        if("hello".equals(authToken)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //返回401未认证错误
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("unAuthorized");
        }
    }

    @Override
    public void destroy() {
        log.info("AuthFilter destroy");
    }
}
