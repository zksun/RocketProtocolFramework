package com.rocket.framework.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zksun on 2019/7/11.
 */

@Controller
public class StateMachine {

    private static Logger logger = LoggerFactory.getLogger(StateMachine.class);

    @RequestMapping("/")
    public String home() {
        return "Hello Hyper Snake State Machine!!";
    }

    @RequestMapping(value = "/api/v1/process", method = RequestMethod.POST)
    public String process(@RequestBody(required = false) String payload) {
        return null;
    }

}
