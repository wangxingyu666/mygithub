package top.wangxingyu.mapper;

import top.wangxingyu.model.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 笼中雀
 */
@Mapper
public interface AnswerMapper {
    List<Answer> findAnswersByQuestionId(int questionId);

    void insertAnswer(Answer answer);
}
