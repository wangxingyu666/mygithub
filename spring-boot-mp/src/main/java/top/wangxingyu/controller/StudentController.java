package top.wangxingyu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangxingyu.entity.Student;
import top.wangxingyu.service.StudentService;

/**
 * @author 笼中雀
 */

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}/courses")
    public Student getStudentWithCourses(@PathVariable Long id){
        return studentService.getStudentWithCourses(id);
    }
}
