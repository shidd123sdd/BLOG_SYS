package cn.siwuya.blogsys.service.impl;

import cn.siwuya.blogsys.common.utils.DateUtils;
import cn.siwuya.blogsys.service.IFileUploadBiz;
import cn.siwuya.blogsys.vo.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author shi_dd
 * @date 2020/7/22 14:13
 */
@Service
@Slf4j
public class FileUploadBizImpl implements IFileUploadBiz {
    @Value("${IMAGE_PRE_PATH}")
    private String IMAGE_PRE_PATH;
    @Value("${REQ_IMG_PATH}")
    private String REQ_IMG_PATH;

    @Override
    public FileInfo uploadImg(MultipartFile formdata) {
        String currDatePath = DateUtils.getCurrDatePath();
        String currTime = String.valueOf(System.currentTimeMillis());
        String fileName = currTime+getFileExtension(formdata);
        String fullPath = IMAGE_PRE_PATH+currDatePath+fileName;
            try {
            File file = new File(fullPath);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            formdata.transferTo(file);

        } catch (IOException e) {
            log.error("图片写入失败："+e);
        }
        return    FileInfo.builder()
                .fileName(fileName)
                .filePath(REQ_IMG_PATH+currDatePath+fileName)
                .createDate(DateUtils.getCurrDate())
                .build();
    }


    private static String getFileExtension(MultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }
}
