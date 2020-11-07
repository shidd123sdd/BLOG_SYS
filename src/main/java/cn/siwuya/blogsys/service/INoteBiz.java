package cn.siwuya.blogsys.service;

import cn.siwuya.blogsys.vo.NoteCondition;
import cn.siwuya.blogsys.vo.NoteVo;

import java.util.Map;

/**
 * @author shi_dd
 * @date 2020/7/23 9:47
 */
public interface INoteBiz {
    void addNote(NoteVo vo);

    Map<String,Object> getColumnList();

    void update(NoteVo vo);

    void delete(Long id);

    Map<String,Object> searchNoteList(NoteCondition noteCondition);
}
