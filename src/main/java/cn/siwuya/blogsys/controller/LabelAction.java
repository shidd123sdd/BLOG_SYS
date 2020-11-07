package cn.siwuya.blogsys.controller;

import cn.siwuya.blogsys.entity.LabelEntity;
import cn.siwuya.blogsys.service.ILabelBiz;
import cn.siwuya.blogsys.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shi_dd
 * @date 2020/7/14 14:03
 */
@RestController
@RequestMapping("/api/label")
public class LabelAction {
    @Autowired
    private ILabelBiz labelBiz;

    @RequestMapping("/getList")
    public JsonResult getList(){
        return new JsonResult(labelBiz.getLabelList());
    }

    @RequestMapping("/addLabel")
    public JsonResult addLabel(@RequestBody LabelEntity entity){
        labelBiz.addLabel(entity);
        return new JsonResult("commit ok");
    }

    @RequestMapping("/updateLabel")
    @ResponseBody
    public JsonResult updateLabel(@RequestBody LabelEntity entity){
        labelBiz.updateLabel(entity);
        return new JsonResult("commit ok");
    }

    @RequestMapping("/delete")
    public JsonResult deleteLabel(Long id){
        labelBiz.deleteLabel(id);
        return new JsonResult("commit ok");
    }
    @RequestMapping("/search")
    public JsonResult searchLabel(String labelName){
        return new JsonResult(labelBiz.searchLabel(labelName));
    }


    @RequestMapping("/getOrgLables")
    public JsonResult getOrgLables(){
        return new JsonResult( labelBiz.getOrgLables());
    }

}
