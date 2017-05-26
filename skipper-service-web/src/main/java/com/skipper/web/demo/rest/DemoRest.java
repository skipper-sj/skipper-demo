package com.skipper.web.demo.rest;

import com.skipper.web.demo.model.vo.DemoVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shoujian on 2017/5/6.
 */
@RestController
public interface DemoRest {

    @RequestMapping("/")
    DemoVO getDemoById();

}
