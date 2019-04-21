package com.linxu.pillow.service;

import com.linxu.pillow.dtos.ResponseData;
import com.linxu.pillow.models.User;

/**
 * @author linxu
 * @date 2019/4/14
 */
public interface UserService {
    ResponseData querySleepReport(String date, int id);

    ResponseData queryAdvice(int id) throws Exception;

    ResponseData login(String code);

    ResponseData queryInfoById(int id);

    ResponseData updateUserInfo(int id, User user);

    ResponseData updateDevice(int userId,int deviceId);
}
