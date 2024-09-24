package top.wangxingyu.springboot.configure.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.wangxingyu.springboot.configure.entity.Mail;
import top.wangxingyu.springboot.configure.service.EmailService;

@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/mail")
    public void sendEmail(@RequestBody Mail mail) {
        emailService.sendSimpleMail(mail.getTo() , mail.getSubject(), mail.getBody());

    }
}
