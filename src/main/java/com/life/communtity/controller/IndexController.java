package com.life.communtity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:Chengzhen
 * @date:2020/3/15
 * @ver:1.0
 **/
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
