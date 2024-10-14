package top.wangxingyu.model;

import lombok.*;

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
    private Date createTime;


}
