package com.dodo.dodoworld.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index() {
        log.info("helloController.index success");
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        log.info("helloController.hello success");
        return "hello";
    }
}
