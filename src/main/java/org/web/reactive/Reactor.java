package org.web.reactive;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-12
 */
public class Reactor {
  public static void main(String[] args) throws Exception {
//        java1();
//        java2();
//        java3();
//        java4();
//    java5();
    java6();
  }

  private static void java6() throws Exception {
    Flux.interval(Duration.ofMillis(250))
        .map(input -> {
          if (input < 3) return "tick " + input;
          throw new RuntimeException("boom");
        })
        .retry(1)
        .elapsed()
        .subscribe(System.out::println, System.err::println);

    TimeUnit.DAYS.sleep(1L);
  }

  private static void java5() throws Exception {
    Flux<Integer> source = Flux.range(1, 3)
        .doOnSubscribe(s -> System.out.println("subscribed to source"));

    ConnectableFlux<Integer> co = source.publish();

    co.subscribe(System.out::println, e -> {
    }, () -> {
    });
    co.subscribe(System.out::println, e -> {
    }, () -> {
    });

    System.out.println("done subscribing");
    Thread.sleep(500);
    System.out.println("will now connect");

    co.connect();
  }

  private static void java4() {
    Flux.defer(() -> Flux.just(1, 2, 3)).subscribe(System.out::println);
  }

  private static void java3() throws Exception {
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
    executor.scheduleAtFixedRate(() -> {
      System.out.println(1);
    }, 500, 500, TimeUnit.MILLISECONDS);

    TimeUnit.DAYS.sleep(1L);
  }

  private static void java2() {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1L, TimeUnit.DAYS, new LinkedBlockingQueue<>());
    for (int i = 0; i < 3; i++) {
      executor.submit(() -> {
        for (int j = 0; j < 100; j++) {
          try {
            TimeUnit.SECONDS.sleep(1L);
          } catch (Exception e) {

          }
          System.out.println(j);
        }
      });

    }
    try {
      TimeUnit.DAYS.sleep(1L);
    } catch (Exception e) {

    }
  }

  private static void java1() throws Exception {
    Flux.interval(Duration.of(500, ChronoUnit.MILLIS)).subscribe(x -> {
      System.out.println(String.format("Thread : %s  data: %s", Thread.currentThread(), x));
    });
    System.out.println();
    TimeUnit.DAYS.sleep(1L);
  }
}
