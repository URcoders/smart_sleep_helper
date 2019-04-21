package com.linxu.pillow.controllers;

import com.linxu.pillow.dtos.Code;
import com.linxu.pillow.dtos.RequestData;
import com.linxu.pillow.dtos.ResponseData;
import com.linxu.pillow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author linxu
 * @date 2019/4/13
 */
@RestController
@CrossOrigin
@RequestMapping("/usercenter")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseData login(@RequestBody Code code) {
        try {
            return userService.login(code.getCode());
        } catch (NullPointerException e) {
            return null;
        }
    }

    @GetMapping("/queryinfo")
    public ResponseData queryUserInfo(@RequestParam("id") int id) {
        return userService.queryInfoById(id);
    }

    @PostMapping("/updateinfo")
    public ResponseData modifyUserInfo(@RequestBody RequestData requestData) {
        try {
            return userService.updateUserInfo(requestData.getId(), requestData.getUser());
        } catch (NullPointerException e) {
            System.err.println("null pointer!");
            return null;
        }
    }

    @PostMapping("/device")
    public ResponseData addOrModifyDevice(@RequestBody RequestData requestData) {
        try {
            return userService.updateDevice(requestData.getId(), requestData.getDeviceId());
        } catch (NullPointerException e) {
            System.err.println("null pointer!");
            return null;
        }
    }
}
