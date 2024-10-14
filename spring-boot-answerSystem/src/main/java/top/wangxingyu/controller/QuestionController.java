package top.wangxingyu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wangxingyu.model.Question;
import top.wangxingyu.service.QuestionService;
import java.util.List;
import top.wangxingyu.util.JwtUtils ;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    // 获取所有问题
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // 获取特定问题
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    // 创建问题
    @PostMapping
    public String createQuestion(@RequestBody Question question, HttpServletRequest request) {
        int userId = JwtUtils.getUserIdFromRequest(request);
        if (userId == -1) {
            return "Unauthorized";
        }
        question.setUserId(userId);
        questionService.createQuestion(question);
        return "Question created successfully";
    }
}
