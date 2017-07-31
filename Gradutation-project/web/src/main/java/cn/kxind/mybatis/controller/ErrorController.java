package cn.kxind.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/4/4.
 */
@Controller
public class ErrorController {

    @GetMapping("/403")
    public String NotFoundAuth() {

        return "error/403";
    }
}
