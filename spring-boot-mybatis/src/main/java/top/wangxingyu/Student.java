package top.wangxingyu;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 笼中雀
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    private Clazz clazz;
    private List<Course> courses;
}
