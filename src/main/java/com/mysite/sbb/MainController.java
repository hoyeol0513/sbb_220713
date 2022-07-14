package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    //시작 메인컨트롤러를 questionlist로 적용
    @RequestMapping("/")
    public String root(){
        return "redirect:/question/list";
    }

    @RequestMapping("/sbbTest")
    @ResponseBody
    public String test(){
        return "test : 하이";
    }
}
