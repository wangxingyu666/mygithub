package top.wangxingyu.filter_interceptor.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.wangxingyu.filter_interceptor.filter.*;

/**
 * @author 笼中雀
 */

@Configuration
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<CustomFilter> filterRegistrationBean(){
//        FilterRegistrationBean<CustomFilter> registrationBean=new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CustomFilter());
//        //设置过滤器拦截的url路径
//        registrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        //设置过滤器拦截的url路径
        registrationBean.addUrlPatterns("/*");
        //设置过滤器的执行顺序
        registrationBean.setOrder(1);
        return registrationBean;
    }

//    @Bean
//    public FilterRegistrationBean<AuthFilter> authFilter() {
//        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new AuthFilter());
//        //设置过滤器拦截的url路径
//        registrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CorsFilter());
//        //设置过滤器拦截的url路径
//        registrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<RateLimitFilter> rateLimitFilter() {
//        FilterRegistrationBean<RateLimitFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new RateLimitFilter());
//        //设置过滤器拦截的url路径
//        registrationBean.addUrlPatterns("/*");
//        //设置过滤器的执行顺序
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }
}
