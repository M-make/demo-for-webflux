package org.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-07
 */
@Controller
public class Sse {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(
            1,1,0L, TimeUnit.DAYS, new LinkedBlockingQueue<>()
    );

    @GetMapping("/sse")
    public SseEmitter sse() {
        SseEmitter emitter = new SseEmitter();
        EXECUTOR_SERVICE.submit(() -> {
            try {
                for (int i = 0; i < 1000000; i++) {
                    Thread.sleep(1000);
                    emitter.send(String.format("%s 第%s个数据",Thread.currentThread().getName(),i));
                }
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }
}
