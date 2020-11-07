package cn.siwuya.blogsys.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shi_dd
 * @date 2020/7/14 14:09
 */
@Data
@Builder
public class LabelListVo {
    private Long id;
    private String labelName;
    private Long parentLabelId;
    private String parentLabelName;
    private Date startDate;
    private Date endDate;
    private boolean isShow;
    private String description;
    private int level;
    private List<LabelListVo> children  = new ArrayList<>();
}
