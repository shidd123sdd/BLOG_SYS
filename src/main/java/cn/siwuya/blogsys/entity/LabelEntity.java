package cn.siwuya.blogsys.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author shi_dd
 * @date 2020/7/14 14:06
 */
@Data
@Builder
public class LabelEntity {
    private Long id;
    private String labelName;
    private int level;
    private Long parentLabelId;
    private String parentLabelName;
   private Date startDate;
   private Date endDate;
   private boolean isShow;
   private String description;
}
