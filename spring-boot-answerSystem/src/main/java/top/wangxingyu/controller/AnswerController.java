package top.wangxingyu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wangxingyu.model.Answer;
import top.wangxingyu.service.AnswerService;
import top.wangxingyu.util.JwtUtils;

import java.util.List;

/**
 * @author 笼中雀
 */
@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable int questionId) {
        List<Answer> answers = answerService.getAnswersByQuestionId(questionId);
        System.out.println(answers);
        return answers;
    }

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
