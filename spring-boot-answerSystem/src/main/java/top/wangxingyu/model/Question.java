package top.wangxingyu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 笼中雀
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private String username;
    private Date createTime;
}
