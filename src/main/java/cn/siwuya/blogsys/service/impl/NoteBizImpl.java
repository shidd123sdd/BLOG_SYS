package cn.siwuya.blogsys.service.impl;

import cn.siwuya.blogsys.common.utils.DateUtils;
import cn.siwuya.blogsys.dao.INoteMapper;
import cn.siwuya.blogsys.entity.ColumnMetaEntity;
import cn.siwuya.blogsys.entity.LabelEntity;
import cn.siwuya.blogsys.service.INoteBiz;
import cn.siwuya.blogsys.vo.NoteCondition;
import cn.siwuya.blogsys.vo.NoteVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shi_dd
 * @date 2020/7/23 9:58
 */
@Service
@Slf4j
public class NoteBizImpl implements INoteBiz {

    @Autowired
    private INoteMapper noteMapper;
    @Override
    public void addNote(NoteVo vo) {
        List<String> labelList = vo.getLabelList();
        if(vo.getType() == 1){
            StringBuffer sb = transArrtoString(labelList);
            vo.setLabels(sb.toString());
        }
        vo.setCreateTime(DateUtils.getCurrDateTime());

        noteMapper.addNote(vo);
    }

    private StringBuffer transArrtoString(List<String> labelList) {
        StringBuffer sb = new StringBuffer();
        final int len = labelList.size();
        for(int i = 0 ;i<len ;i++){
            if(i==len-1){
                sb.append(labelList.get(i));
            }else{
                sb.append(labelList.get(i)).append(";");
            }
        }
        return sb;
    }

    @Override
    public Map<String, Object> getColumnList() {
        List<ColumnMetaEntity> columnMetaList = noteMapper.getColumn();
        List<NoteVo> resList = noteMapper.getNoteList();
        List<LabelEntity> labelList= noteMapper.getLabelList();
        Map<String,Object> res = new HashMap<>();
        List<NoteVo> noteList = new LinkedList<>();
        List<NoteVo> artList = new LinkedList<>();
        List<ColumnMetaEntity> noteColumns = new LinkedList<>();
        List<ColumnMetaEntity> artColoumns = new LinkedList<>();

        for (NoteVo vo : resList) {
            if(vo.getType() == 1){
                noteList.add(vo);
            }else if(vo.getType() == 2){
                artList.add(vo);
            }
        }
        for (ColumnMetaEntity entry : columnMetaList) {
            if(entry.getTableId().equals("note_info")){
                noteColumns.add(entry);
            }else if(entry.getTableId().equals("art_info")){
                artColoumns.add(entry);
            }
        }


        for (NoteVo vo: noteList) {
            String labels = vo.getLabels();
           List<String> labelArr= Arrays.asList(labels.split(";"));
            vo.setLabelList(labelArr);
        }
        res.put("noteColumns",noteColumns);
        res.put("artColoumns",artColoumns);
        res.put("noteList",noteList);
        res.put("artList",artList);
        res.put("labelList",labelList);
        return res;
    }

    @Override
    public void update(NoteVo vo) {
        List<String> labelList = vo.getLabelList();
        if(vo.getType() == 1){
            StringBuffer sb = transArrtoString(labelList);
            vo.setLabels(sb.toString());
        }
        vo.setUpdateTime(DateUtils.getCurrDateTime());
        noteMapper.update(vo);
    }

    @Override
    public void delete(Long id) {
        noteMapper.delete(id);
    }

    @Override
    public Map<String, Object> searchNoteList(NoteCondition noteCondition) {
        List<NoteVo> noteList = noteMapper.search(noteCondition);
        List<NoteVo> resList = new LinkedList<>();

        if(noteCondition.getLabelList() != null &&noteCondition.getLabelList().size()>0 ){
            outer:
            for (NoteVo noteVo: noteList) {
                String labels = noteVo.getLabels();
                String[] strings = labels.split(";");
                List<String> list = Arrays.asList(strings);
                for(String conLabel :noteCondition.getLabelList()){
                    for (String str: list) {
                        if(str.equals(conLabel)){
                            resList.add(noteVo);
                            continue outer;
                        }
                    }
                }
            }
        }else{
            resList = noteList;
        }
        if(noteCondition.getType() == 1){
            for (NoteVo vo: resList) {
                String labels = vo.getLabels();
                List<String> labelArr= Arrays.asList(labels.split(";"));
                vo.setLabelList(labelArr);
            }
        }

        Map<String,Object> res = new HashMap<>();
        res.put("noteList",resList);
        return res;
    }
}
