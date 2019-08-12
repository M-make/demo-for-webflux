package org.web.mvc;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-07-29
 */
@Controller
public class Thymeleaf extends ApplicationObjectSupport {

  @RequestMapping("/**")
  public String getAll(Model model) {
    model.addAttribute("name", "虎");
    return "index";
  }

}
