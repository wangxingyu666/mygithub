package top.wangxingyu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * @author 笼中雀
 */

@Data
@TableName("t_user")
public class User {
    @TableId(value = "pk_id",type= IdType.AUTO)
    private Long pkId;

    private String phone;

    private String avatar;

    private String nickname;

    private Integer gender;

    private Integer bonus;

    private String remark;

    private Integer enabled;

    @TableField(value = "delete_flag",fill= FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    @TableField(value="update_time",fill=FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
