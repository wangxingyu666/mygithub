package top.wangxingyu.filter_interceptor.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.wangxingyu.filter_interceptor.interceptor.AuthInterceptor;
import top.wangxingyu.filter_interceptor.interceptor.CorsInterceptor;
import top.wangxingyu.filter_interceptor.interceptor.LoggingInterceptor;
import top.wangxingyu.filter_interceptor.interceptor.UploadImageInterceptor;

/**
 * @author 笼中雀
 */

@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;
    private final AuthInterceptor authInterceptor;
    private final CorsInterceptor corsInterceptor;
    private final UploadImageInterceptor uploadImageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加了拦截器，并添加了拦截地址
        //registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(authInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(uploadImageInterceptor).addPathPatterns("/api/upload");
    }
}
