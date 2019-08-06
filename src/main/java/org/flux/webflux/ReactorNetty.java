package org.flux.webflux;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-07-31
 */
public class ReactorNetty {
    public static void main(String[] args) throws Exception{
        LoggingSystem.get(ReactorNetty.class.getClassLoader()).setLogLevel("root", LogLevel.INFO);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpServer.create()   // Prepares an HTTP server ready for configuration
                .port(10010)    // Configures the port number as zero, this will let the system pick up
                .route(routes ->
                        routes
                                 .get("/test1/{param}", (request, response) ->
                                     response.sendString(Mono.justOrEmpty(request.param("param")))
                                ).get("/test2/{param}", (request, response) ->
                                {
                                    try {
                                        response.addHeader("Content-Type","application/json");
                                        return response.sendString(Mono.justOrEmpty(objectMapper.writeValueAsString(
                                                request.params()
                                        )));
                                    } catch (JsonProcessingException e) {
                                        return Mono.error(e);
                                    }
                                }).get("/test3",(request,response)->{
                                    Map<String,Object> map = new HashMap<>();
                                    map.put("name","BIG");
                            try {
                                response.addHeader(HttpHeaders.CONTENT_TYPE,MediaType.TEXT_HTML_VALUE);
                                String index = new TemplateEngine().process(
                                        log(new String(Files.readAllBytes(
                                                Paths.get(Thread.currentThread().getContextClassLoader().getResource("static/index.html").toURI())
                                        ))), new Context(Locale.CHINA, map));
                                return response.sendString(Mono.just(index));
                            } catch (Exception e) {
                                return response.sendString(Mono.error(e));
                            }
                        })
                )
                .bindUntilJavaShutdown(Duration.ZERO,null);
    }

    public static <T> T log(T t){
        System.out.println(t);
        return t;
    }
}
