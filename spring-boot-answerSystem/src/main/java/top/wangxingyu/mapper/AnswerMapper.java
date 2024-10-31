package top.wangxingyu.mapper;

import top.wangxingyu.model.Answer;

import java.util.List;

/**
 * @author 笼中雀
 */
public interface AnswerMapper {
    List<Answer> findAnswersByQuestionId(int questionId);
    void insertAnswer(Answer answer);
}
