package com.linyoujian.dream.service;

import com.linyoujian.dream.dao.UserDao;
import com.linyoujian.dream.model.User;
import com.linyoujian.dream.model.vo.UserParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public boolean login(String email, String password, String nickname) {
        User user=userDao.selectByPrimaryKey(email);
        if (email==null){
            return false;
        }
        return false;
    }

    @Override
    public boolean register(UserParam userParam) {
        User user=new User();
        user.setEmail(userParam.getEmail());
        user.setPassword(userParam.getPassword());
        user.setNickname(userParam.getNickname());
        user.setCreateTime(new Date());
        int count=userDao.insertSelective(user);
        if (count==0){
            return false;
        }
        return true;
    }
}
