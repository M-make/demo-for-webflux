package org.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WebfluxApplication {

  public void show1(){}

  public static void main(String[] args) throws Exception {
    SpringApplication.run(WebfluxApplication.class, args);
    String s = "";
  }

  public void show(){}

  @Bean
  public HandlerMapping handlerMapping() {
    SimpleUrlHandlerMapping urlHandlerMapping =
        new SimpleUrlHandlerMapping();
    Map<String, Object> urlMap = new HashMap<>();
    urlMap.put("/ws", (WebSocketHandler) (session) -> session
        .send(session.receive()
            .map(msg -> "RECEIVED ON SERVER :: " + msg.getPayloadAsText())
            .map(session::textMessage)
            .map((mes) -> {
              System.out.println(mes.getPayloadAsText());
              return mes;
            })
        ));
    urlHandlerMapping.setUrlMap(urlMap);
    urlHandlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return urlHandlerMapping;
  }

  @Bean
  public HandlerAdapter handlerAdapter() {
    return new WebSocketHandlerAdapter();
  }

}
