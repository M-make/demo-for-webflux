package org.flux.webflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-07-29
 */
@Controller
public class Web {

    @RequestMapping("/**")
    public String getAll(Model model){
        model.addAttribute("name","虎");
        return "index";
    }

}
