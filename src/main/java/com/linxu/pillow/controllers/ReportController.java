package com.linxu.pillow.controllers;

import com.linxu.pillow.dtos.ResponseData;
import com.linxu.pillow.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author linxu
 * @date 2019/4/14
 */
@RestController
@CrossOrigin
@RequestMapping("/report")
public class ReportController {
    @Resource
    private UserService userService;

    @GetMapping("/sleep")
    public ResponseData reportSleep(@RequestParam("date") String date, @RequestParam("id") int id) {
        return userService.querySleepReport(date, id);

    }

    public ResponseData reportAdvice() {
        return null;
    }
}
