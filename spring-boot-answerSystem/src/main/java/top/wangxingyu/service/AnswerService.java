package top.wangxingyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wangxingyu.mapper.AnswerMapper;
import top.wangxingyu.model.Answer;

import java.util.List;
@Service
public class AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    public List<Answer> getAnswersByQuestionId(int questionId) {
        return answerMapper.findAnswersByQuestionId(questionId);
    }

    public void createAnswer(Answer answer) {
        answerMapper.insertAnswer(answer);
    }
}
