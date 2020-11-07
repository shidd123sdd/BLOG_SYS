package cn.siwuya.blogsys.dao;

import cn.siwuya.blogsys.entity.ColumnMetaEntity;
import cn.siwuya.blogsys.entity.LabelEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author shi_dd
 * @date 2020/7/14 14:14
 */
@Mapper
public interface ILabelMapper {

    @Select("select * from label_info order by level ")
    List<LabelEntity> getLabelList();


    @Insert("insert into label_info (label_name , level ,parent_label_id,parent_label_name," +
            "start_date,end_date,is_show ,description)" +
            " values (#{labelName},#{level},#{parentLabelId}," +
            "#{parentLabelName},#{startDate},#{endDate},#{isShow},#{description})")
    void addLabel(LabelEntity entity);

    @Select("select * from column_meta where table_id = 'label_info' order by sort_order" )
    List<ColumnMetaEntity> getLabelColumn();

    @Update("update label_info set label_name = #{labelName} ," +
                                    "level = #{level} ," +
                                    "parent_label_id = #{parentLabelId} ,  " +
                                     "parent_label_name = #{parentLabelName} ,  " +
                                    "  start_date = #{startDate} ," +
                                     " end_date = #{endDate} ," +
                                    "is_show = #{isShow} ," +
                                    "description = #{description}" +
                                    " where id = #{id}")
    void updateLabel(LabelEntity entity);

    @Delete("delete from label_info where id = #{id}" )
    void deleteLabel(Long id);

    @Select("select * from label_info where label_name like concat('%',#{labelName,jdbcType=VARCHAR},'%')  order by level ")
    List<LabelEntity> searchLabel(String labelName);
    @Select("select * from label_info order by level")
    List<LabelEntity> getOrgLables();
}
