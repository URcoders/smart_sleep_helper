package com.linxu.pillow.service;

import com.linxu.pillow.dtos.ResponseData;

/**
 * @author linxu
 * @date 2019/4/14
 */
public interface UserService {
    ResponseData querySleepReport(String date,int id);
    ResponseData queryAdvice(int id);
}
