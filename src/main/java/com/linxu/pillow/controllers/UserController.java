package com.linxu.pillow.controllers;

import com.linxu.pillow.dtos.Code;
import com.linxu.pillow.dtos.ResponseData;
import org.springframework.web.bind.annotation.*;

/**
 * @author linxu
 * @date 2019/4/13
 */
@RestController
@CrossOrigin
@RequestMapping("/usercenter")
public class UserController {
    @PostMapping("/login")
    public ResponseData login(@RequestBody Code code){

        return null;
    }
    @GetMapping("/info")
    public ResponseData queryUserInfo(@RequestParam("id")int id){
        return null;
    }

}
