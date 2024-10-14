package top.wangxingyu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 笼中雀
 */
@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;


    //声明数据表中不存在teacher列一对一
    @TableField(exist = false)
    private Teacher teacher;
}
