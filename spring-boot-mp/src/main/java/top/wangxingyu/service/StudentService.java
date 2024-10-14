package top.wangxingyu.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.wangxingyu.entity.Course;
import top.wangxingyu.entity.Student;
import top.wangxingyu.mapper.StudentCourseMapper;
import top.wangxingyu.mapper.StudentMapper;

import java.util.List;

/**
 * @author 笼中雀
 */
@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;

    public Student getStudentWithCourses(Long studentId) {
        Student student = studentMapper.selectById(studentId);
        if (student != null) {
            List<Course> courses = studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;
    }
}
