package com.kh.app03.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public void home(){
        System.out.println("홈페이지야옹~~");
    }
}
