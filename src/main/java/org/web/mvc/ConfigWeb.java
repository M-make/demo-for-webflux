package org.web.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-13
 */
@Configuration
public class ConfigWeb implements WebMvcConfigurer {

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.addPathPrefix("/hello",(x)->x.equals(Thymeleaf.class));
  }
}
