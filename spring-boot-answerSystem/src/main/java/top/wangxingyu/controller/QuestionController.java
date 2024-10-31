package top.wangxingyu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wangxingyu.model.Question;
import top.wangxingyu.service.QuestionService;
import top.wangxingyu.util.JwtUtils;

import java.util.List;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }


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