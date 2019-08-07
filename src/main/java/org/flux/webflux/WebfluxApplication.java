package org.flux.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) throws Exception{
        SpringApplication.run(WebfluxApplication.class, args);
    }

//    @Bean
//    public HandlerMapping handlerMapping(){
//        SimpleUrlHandlerMapping urlHandlerMapping =
//                new SimpleUrlHandlerMapping();
//        Map<String,Object> urlMap = new HashMap<>();
//        urlMap.put("/ws",(WebSocketHandler)(session)-> session
//                .send( session.receive()
//                        .map(msg -> "RECEIVED ON SERVER :: " + msg.getPayloadAsText())
//                        .map(session::textMessage)
//                        .map((mes)->{
//                            System.out.println(mes.getPayloadAsText());
//                            return mes;
//                        })
//                ));
//        urlHandlerMapping.setUrlMap(urlMap);
//        urlHandlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return urlHandlerMapping;
//    }
//
//    @Bean
//    public HandlerAdapter handlerAdapter(){
//	    return new WebSocketHandlerAdapter();
//    }

}
