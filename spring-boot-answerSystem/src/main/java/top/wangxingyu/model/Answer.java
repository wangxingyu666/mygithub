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
public class Answer {
    private Integer id;
    private String content;
    private Integer questionId;
    private Integer userId;
    private String username;
    private Date createdTime;
}
