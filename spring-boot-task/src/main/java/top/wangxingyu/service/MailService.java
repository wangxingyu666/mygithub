package top.wangxingyu.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.wangxingyu.entity.EmailLog;
import top.wangxingyu.mapper.EmailLogMapper;

import java.time.LocalDateTime;

/**
 * @author 笼中雀
 */
@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;
    private final EmailLogMapper emailLogMapper;

    public void sendMail(String to,String subject,String content){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("3318547703@qq.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);

        EmailLog emailLog=new EmailLog();

        emailLog.setRecipient(to);
        emailLog.setSubject(subject);
        emailLog.setContent(content);
        emailLog.setSentAt(LocalDateTime.now());
        emailLogMapper.insert(emailLog);
        log.info("邮件已发送至:{}",to);
    }
}
