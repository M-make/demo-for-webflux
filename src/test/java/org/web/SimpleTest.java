package org.web;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-07-29
 */
public class SimpleTest {
    @Test
    public void test1(){


        /**
         *
         * FluxArray 发布者
         * LambdaSubscriber 订阅者
         * {@link FluxArray#subscribe()} 发布者调用订阅方法
         * {@link reactor.core.publisher.LambdaSubscriber#onSubscribe(Subscription)} 订阅者执行订阅动作
         *
         *
         *  1.Flux.formArray 生成一个发布者 FluxArray
         *  2.发布者调用subscribe方法，生成一个订阅者，并且执行，发布者的订阅动作通知订阅者，执行
         *  订阅者的onSubscribe方法
         *
         */

        Flux.fromArray(new Object[]{"1","2"})
                .concatMap(x-> {
                    if ("1".equals(x)){
                        return Mono.empty();
                    }
                    return Mono.just(112312312);
                })
//                .next()
                .subscribe(System.out::println);


    }
}
