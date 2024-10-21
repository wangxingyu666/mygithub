package top.wangxingyu.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 笼中雀
 */
@Data
@Schema(description = "用户信息")
public class UserInfoVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6849515280553569103L;

    @Schema(description = "主键")
    private Long pkId;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private Integer gender;

    @Schema(description = "积分")
    private Integer bonus;

    @Schema(description = "描述")
    private String remark;
}
