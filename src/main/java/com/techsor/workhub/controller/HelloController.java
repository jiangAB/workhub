package com.techsor.workhub.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
        @GetMapping(value = "/hello")
        public String hello(
//                @RequestParam(value = "nickname", required = false)
                String nickname
        ) {
            if(nickname != null)
                return "你好" + nickname;
            else
                return "你好";
        }
}
