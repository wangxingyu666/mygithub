package top.wangxingyu.filter_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 笼中雀
 */
@SpringBootApplication
//@ServletComponentScan
public class FilterInterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorApplication.class,args);
    }
}
