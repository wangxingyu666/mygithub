package top.wangxingyu.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.wangxingyu.entity.Clazz;
import top.wangxingyu.entity.Teacher;
import top.wangxingyu.mapper.ClazzMapper;

/**
 * @author 笼中雀
 */
@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;


    //根据班级id查询班级信息（包含教师信息）
    public Clazz getClazzWithTeacher(Long clazzId){
        Clazz clazz=clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher=clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
        clazz.setTeacher(teacher);
        }
        return clazz;
    }

}
