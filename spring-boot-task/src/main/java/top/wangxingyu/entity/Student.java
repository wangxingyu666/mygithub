package top.wangxingyu.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 笼中雀
 */
@Data
@TableName("t_student")
public class Student {
    @ExcelProperty("学生学号")
    private Integer studentId;

    @ExcelIgnore
    private Integer clazzId;

    @ExcelProperty("学生姓名")
    private String studentName;

    @ExcelProperty("家乡")
    private String hometown;

    @ExcelIgnore
    private Date birthday;
}
