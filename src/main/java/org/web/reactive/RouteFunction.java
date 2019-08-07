package org.web.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-07
 */
@Controller
public class RouteFunction {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return (ServerRequest request)->
                Mono.just((HandlerFunction<ServerResponse>)(res)->ServerResponse.ok().syncBody("11"));
    }
}
