package cn.siwuya.blogsys.vo;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @author shi_dd
 * @date 2020/7/27 20:26
 */
@Data
public class NoteCondition {
    private String offTitle;
    private String subTitle;
    private List<String> labelList;
    private String labelStr;
    private String startTime;
    private String endTime;
    private int type;
}
