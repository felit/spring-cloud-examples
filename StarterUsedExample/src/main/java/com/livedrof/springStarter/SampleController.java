package com.livedrof.springStarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class SampleController {

    @Autowired
    private UserService t=null;

    @RequestMapping("/")
    String home() {
        t.helloStarter();
        return "Hello World!";
    }
}