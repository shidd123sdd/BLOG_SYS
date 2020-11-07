package cn.siwuya.blogsys.service.impl;

import cn.siwuya.blogsys.dao.ILabelMapper;
import cn.siwuya.blogsys.entity.ColumnMetaEntity;
import cn.siwuya.blogsys.entity.LabelEntity;
import cn.siwuya.blogsys.service.ILabelBiz;
import cn.siwuya.blogsys.vo.LabelListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shi_dd
 * @date 2020/7/14 14:12
 */
@Service
@Slf4j
public class LabelBizImpl implements ILabelBiz {
    @Autowired
    private ILabelMapper labelDao;

    @Override
    public Map<String,Object> getLabelList() {
       List<LabelEntity> labelList= labelDao.getLabelList();
       if(labelList.size() == 0) {return null;}
       List<LabelListVo> labelListVo= new ArrayList<>();
        setLabelListVo(labelList, labelListVo);
        log.info("labelList",labelListVo);
        List<ColumnMetaEntity> labelColumnList = labelDao.getLabelColumn();
        Map<String,Object> resMap =  new HashMap<>();
        resMap.put("labelList",labelListVo);
        resMap.put("labelColumnList",labelColumnList);
        return resMap;
    }

    private void setLabelListVo(List<LabelEntity> labelList, List<LabelListVo> labelListVo) {
        //设置根节点
        for ( LabelEntity entity: labelList) {
            if(entity.getLevel() == 1){
                LabelListVo vo = createLabelVo(entity);
                labelListVo.add(vo);
            }
        }

        //设置叶子节点
        for(LabelEntity entity : labelList) {
                setVoList(labelListVo, entity);
        }
    }

    /**
     * 新增
     * @param entity
     */
    @Override
    public void addLabel(LabelEntity entity) {
        labelDao.addLabel(entity);
    }

    @Override
    public void updateLabel(LabelEntity entity) {
        labelDao.updateLabel(entity);
    }

    @Override
    public void deleteLabel(Long id) {
        labelDao.deleteLabel(id);
    }

    @Override
    public Map<String,Object> searchLabel(String labelName) {
        List<LabelEntity> labelList = labelDao.searchLabel(labelName);
        Map<String,Object> resMap = new HashMap<>();
        if(labelList.size() == 0 ) {
            resMap.put("labelList",null);
            return resMap;
        }else if(labelName !=null && !labelName.equals("")){
            resMap.put("labelList",labelList);
            return resMap;
        }
        return getLabelList();
    }

    @Override
    public List<LabelEntity> getOrgLables() {
        return labelDao.getOrgLables();
    }

    /**
     * 设置树形结构
     * @param labelList
     * @param labelEntity
     * @return
     */
    private void setVoList(List<LabelListVo> labelList ,  LabelEntity labelEntity) {
        for(LabelListVo vo : labelList){
            if(labelEntity.getParentLabelId() == null ){
                continue;
            }
            List<LabelListVo> child =  vo.getChildren();
            if(labelEntity.getParentLabelId() != null &&labelEntity.getParentLabelId().equals(vo.getId())){
                if (child == null) {
                    child= new ArrayList<>();
                }
                child.add(createLabelVo(labelEntity));
                vo.setChildren(child);
                return ;
            }else{
                if(child != null && child.size()>0){
                    setVoList(child, labelEntity);
                }
            }
        }
    }


    private LabelListVo createLabelVo(final LabelEntity labelEntity){
        return LabelListVo.builder()
                .id(labelEntity.getId())
                .labelName(labelEntity.getLabelName())
                .startDate(labelEntity.getStartDate())
                .endDate(labelEntity.getEndDate())
                .isShow(labelEntity.isShow())
                .description(labelEntity.getDescription())
                .level(labelEntity.getLevel())
                .parentLabelId(labelEntity.getParentLabelId())
                .parentLabelName(labelEntity.getParentLabelName())
                .build();
    }
}
