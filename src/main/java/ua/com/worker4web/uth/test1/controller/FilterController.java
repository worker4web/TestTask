package ua.com.worker4web.uth.test1.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by worker4web on 10/25/2017.
 */

@RestController
@EnableAutoConfiguration
public class FilterController {

    @RequestMapping("/")
    public String income() {
        return "Ok!";
    }

}
