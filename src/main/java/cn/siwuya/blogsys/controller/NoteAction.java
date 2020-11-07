package cn.siwuya.blogsys.controller;

import cn.siwuya.blogsys.service.IFileUploadBiz;
import cn.siwuya.blogsys.service.INoteBiz;
import cn.siwuya.blogsys.vo.FileInfo;
import cn.siwuya.blogsys.vo.JsonResult;
import cn.siwuya.blogsys.vo.NoteCondition;
import cn.siwuya.blogsys.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author shi_dd
 * @date 2020/7/21 16:46
 */
@RestController
@RequestMapping("/api/note")
public class NoteAction {
    @Autowired
    private INoteBiz noteBiz;
    @Autowired
    private IFileUploadBiz fileUploadBiz;

    @RequestMapping("/addNote")
    @ResponseBody
    public JsonResult addNote(@RequestBody NoteVo vo){
        noteBiz.addNote(vo);
       return new JsonResult( "ok");
    }


    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        noteBiz.delete(id);
        return new JsonResult( "ok");
    }
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestBody NoteVo vo){
        noteBiz.update(vo);
        return new JsonResult( "ok");
    }

    @RequestMapping("/uploadImg")
    @ResponseBody
    public JsonResult uploadImg(@RequestParam("image") MultipartFile formdata){
        FileInfo fileInfo= fileUploadBiz.uploadImg(formdata);
        return new JsonResult(fileInfo);
    }

    @RequestMapping("/getColumnList")
    @ResponseBody
    public JsonResult getColumnList(){
            return new JsonResult(noteBiz.getColumnList());
    }

    @RequestMapping("/search")
            @ResponseBody
    public JsonResult search(@RequestBody NoteCondition noteCondition){
        return  new JsonResult(noteBiz.searchNoteList(noteCondition));
    }
}
