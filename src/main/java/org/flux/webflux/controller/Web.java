package org.flux.webflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-07-29
 */
@RestController
public class Web {

    @RequestMapping("/**")
    public Mono<Object> getAll(){
        return Mono.just("Hello");
    }

}
