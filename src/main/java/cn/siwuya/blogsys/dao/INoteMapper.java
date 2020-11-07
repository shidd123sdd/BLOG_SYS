package cn.siwuya.blogsys.dao;

/**
 * @author shi_dd
 * @date 2020/7/23 10:00
 */

import cn.siwuya.blogsys.entity.ColumnMetaEntity;
import cn.siwuya.blogsys.entity.LabelEntity;
import cn.siwuya.blogsys.vo.NoteCondition;
import cn.siwuya.blogsys.vo.NoteVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface INoteMapper {
    @Insert("insert into note_info (off_title,sub_title,labels,dom_str,content,create_time,img_path,type) " +
            "values (#{offTitle},#{subTitle},#{labels},#{domStr},#{content},#{createTime},#{imgPath},#{type})")
    void addNote(NoteVo vo);

    @Select("select * from column_meta where table_id = 'note_info' or table_id = 'art_info' order by sort_order " )
    List<ColumnMetaEntity> getColumn();

    @Select("select * from note_info   order by create_time desc")
    List<NoteVo> getNoteList();

    @Select("select * from label_info where is_show=true ")
    List<LabelEntity> getLabelList();


    @Update("update note_info set off_title = #{offTitle}," +
            "sub_title = #{subTitle}," +
            "labels = #{labels}," +
            "dom_str = #{domStr}," +
            "content = #{content}," +
            "update_time = #{updateTime}, " +
            "img_path = #{imgPath} " +
            "where id= #{id}" )
    void update(NoteVo vo);

    @Delete("delete from note_info where id =#{id}")
    void delete(Long id);

//    @Select("select * from note_info where off_title like concat('%',#{offTitle,jdbcType=VARCHAR},'%')" +
//            "and  sub_title like concat('%',#{subTitle,jdbcType=VARCHAR},'%')" +
//            "and create_time between #{startTime} and #{endTime}")


    @Select({"<script>",
           "select * from note_info",
            "WHERE type = #{type}",
            "<when test='offTitle!=null'>",
            "AND off_title like concat('%',#{offTitle,jdbcType=VARCHAR},'%')",
            "</when>",
            "<when test='subTitle!=null'>",
            "AND sub_title like concat('%',#{subTitle,jdbcType=VARCHAR},'%')",
            "</when>",
            "<when test='startTime!=null'>",
            "AND create_time between #{startTime} and #{endTime}",
            "</when> order by create_time desc" ,
            "</script>"})
    List<NoteVo> search(NoteCondition noteCondition);
}
