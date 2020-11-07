package cn.siwuya.blogsys.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author shi_dd
 * @date 2020/7/16 10:03
 */
@Data
@Builder
public class ColumnMetaEntity {
    private String tableId;
    private String title;
    private String dataIndex;
    private String key;
    private String width;
    private int sortOrder;
    private String align;
}
