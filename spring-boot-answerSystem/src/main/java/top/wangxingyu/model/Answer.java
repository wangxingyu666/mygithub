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
public class Answer {
    private Integer id;
    private String content;
    private Integer questionId;
    private Integer userId;
    private Date createdAt;

}
