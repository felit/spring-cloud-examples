package com.livedrof.springBoot;

import com.livedrof.springBoot.annotation.OperateLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    @OperateLog("测试")
    public String index() {
        log.info("hello spring boot");
        return "Hello world";
    }

}
