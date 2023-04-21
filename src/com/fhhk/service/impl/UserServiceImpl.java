package com.fhhk.service.impl;

import com.fhhk.service.UserService;
import com.fhhk.utils.VerifyCodeUtils;

public class UserServiceImpl implements UserService {
    @Override
    public String checkCode() {
        return VerifyCodeUtils.generateVerifyCode(4);
    }
}
