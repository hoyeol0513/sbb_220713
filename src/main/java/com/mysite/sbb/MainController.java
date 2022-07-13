package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class MainController {
    @RequestMapping("")
    @ResponseBody
    public String test(){
        return "하이";
    }
}
