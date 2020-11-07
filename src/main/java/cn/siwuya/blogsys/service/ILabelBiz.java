package cn.siwuya.blogsys.service;

import cn.siwuya.blogsys.entity.LabelEntity;
import cn.siwuya.blogsys.vo.LabelListVo;

import java.util.List;
import java.util.Map;

/**
 * @author shi_dd
 * @date 2020/7/14 14:12
 */
public interface ILabelBiz {
    Map<String,Object> getLabelList();

    void addLabel(LabelEntity entity);

    void updateLabel(LabelEntity entity);

    void deleteLabel(Long id);

    Map<String,Object>  searchLabel(String labelName);

    List<LabelEntity> getOrgLables();
}
