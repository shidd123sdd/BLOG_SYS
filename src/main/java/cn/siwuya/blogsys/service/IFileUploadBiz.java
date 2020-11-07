package cn.siwuya.blogsys.service;

import cn.siwuya.blogsys.vo.FileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shi_dd
 * @date 2020/7/22 14:09
 */
public interface IFileUploadBiz {
    FileInfo uploadImg(MultipartFile formdata);
}
