package top.wangxingyu.mapper;

import top.wangxingyu.model.Question ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 笼中雀
 */
@Mapper
public interface QuestionMapper {
    List<Question> findAllQuestions();

    Question findQuestionById(int id);

    void insertQuestion(Question question);
}
