package top.wangxingyu.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.wangxingyu.service.ExceptionService;

/**
 * @author 笼中雀
 */
@RestController
public class ExceptionController {
    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/articles/{id}")
    public void getArticle(@PathVariable("id") Integer id){
        if(id==1){
            exceptionService.unAuthorizedError();
        }else {
            exceptionService.systemError();
        }
    }
}
