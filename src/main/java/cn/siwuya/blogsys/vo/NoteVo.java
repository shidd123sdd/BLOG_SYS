package cn.siwuya.blogsys.vo;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @author shi_dd
 * @date 2020/7/21 19:25
 */
@Data
public class NoteVo {
    private Long id;
   private String offTitle ;
   private String subTitle;
   private List<String> labelList;
   private String labels;
  private  String domStr;
  private  String content;
  private String createTime;
  private String updateTime;
  private String imgPath;
  private Integer type;
}
