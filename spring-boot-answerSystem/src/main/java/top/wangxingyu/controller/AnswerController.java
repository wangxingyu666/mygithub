package top.wangxingyu.controller;
import jakarta.servlet.http.HttpServletRequest;
import top.wangxingyu.model.Answer ;
import top.wangxingyu.service.AnswerService ;
import top.wangxingyu.util.JwtUtils ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    // 获取特定问题的所有回答
    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable int questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    }

    // 创建回答
    @PostMapping
    public String createAnswer(@RequestBody Answer answer, HttpServletRequest request) {
        int userId = JwtUtils.getUserIdFromRequest(request);
        if (userId == -1) {
            return "Unauthorized";
        }
        answer.setUserId(userId);
        answerService.createAnswer(answer);
        return "Answer created successfully";
    }
}
