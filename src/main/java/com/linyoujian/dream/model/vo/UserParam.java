package com.linyoujian.dream.model.vo;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;
@Data
public class UserParam implements Serializable{
        @NotNull
        private String email;
        @NotNull
        private String password;
        private String nickname;
    }
