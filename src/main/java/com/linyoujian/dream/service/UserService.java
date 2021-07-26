package com.linyoujian.dream.service;

import com.linyoujian.dream.model.vo.UserParam;

public interface UserService {
    boolean login(String email,String password,String nickname);

    boolean register(UserParam userParam);
}
