package top.wangxingyu.mapper;

import top.wangxingyu.Teacher;

/**
 * @author 笼中雀
 */
public interface TeacherMapper {
    //根据id查询教师信息（同时通过一对一查询出其管理的班级信息）

    Teacher findTeacherById(int teacherId);
}
