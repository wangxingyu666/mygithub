package top.wangxingyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wangxingyu.mapper.QuestionMapper;
import top.wangxingyu.model.Question;

import java.util.List;


@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public List<Question> getAllQuestions() {
        return questionMapper.findAllQuestions();
    }

    public Question getQuestionById(int id) {
        return questionMapper.findQuestionById(id);
    }

    public void createQuestion(Question question) {
        questionMapper.insertQuestion(question);
    }
}
