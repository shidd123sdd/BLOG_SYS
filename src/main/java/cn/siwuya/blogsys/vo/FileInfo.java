package cn.siwuya.blogsys.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author shi_dd
 * @date 2020/7/22 14:10
 */
@Data
@Builder
public class FileInfo {
    private String fileName;
    private String filePath;
    private String createDate;
}
