package com.linyoujian.dream.controller;

import com.linyoujian.dream.dao.UserDao;
import com.linyoujian.dream.model.User;
import com.linyoujian.dream.model.vo.UserParam;
import com.linyoujian.dream.service.UserService;
import com.linyoujian.dream.util.Msg;
import com.linyoujian.dream.util.ResultUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UserDao userDao;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Msg register(@RequestBody UserParam userParam) {
        User user = new User();
        user.setEmail(userParam.getEmail());
        int num = userDao.selectCount(user);
        if (num > 0) {
            return ResultUtil.error(400, "账号已存在！");
        }
        Boolean isTrue = userService.register(userParam);
        if (isTrue) {
            return ResultUtil.success(200, "注册成功");
        } else {
            return ResultUtil.error(400, "注册失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(@RequestBody UserParam userParam) {
        User user = new User();
        user.setEmail(userParam.getEmail());
        user = userDao.selectOne(user);
        if (user == null) {
            return ResultUtil.success(400, "该账号不存在");
        } else {
            if (user.getPassword().equals(userParam.getPassword())) {
                return ResultUtil.success(200, "登陆成功");
            }
            return ResultUtil.error(400, "出现异常");
        }
    }

    @RequestMapping("/test")
    public String hello(){
        return "你好";
    }
}
