package cn.siwuya.blogsys.controller;

import cn.siwuya.blogsys.service.IUserBiz;
import cn.siwuya.blogsys.vo.JsonResult;
import cn.siwuya.blogsys.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author shi_dd
 * @date 2020/7/10 13:36
 */
@RestController
@RequestMapping("/api/user")
public class UserAction {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping("/login")
    public JsonResult login(@RequestBody LoginUser userInfo){
        return new JsonResult(userBiz.login(userInfo.getUsername(),userInfo.getPassword()));
    }
}
