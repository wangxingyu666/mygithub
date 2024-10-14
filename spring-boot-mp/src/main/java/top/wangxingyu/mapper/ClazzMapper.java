package top.wangxingyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.wangxingyu.entity.Clazz;
import top.wangxingyu.entity.Teacher;

public interface ClazzMapper extends BaseMapper<Clazz> {

    @Select("SELECT * FROM teacher WHERE id= #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);
}
