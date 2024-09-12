package top.wangxingyu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
    @GetMapping("/msg")
    public String getMsg(Model model){
        //将"message"属性传到视图
        model.addAttribute("msg","Hello,Thymeleaf!");
        //返回的视图名称:默认在resources/templates/msg.html
        return "msg";
    }
}
