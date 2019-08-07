package org.web.reactive;

import io.reactivex.Observable;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-07
 */
public class Rxjava {
    public static void main(String[] args) {
        RxJava1();
    }

    private static void RxJava1() {
        Observable observable = Observable.create(observer->{
            observer.onNext("处理的数字："+Math.random()*100);
            observer.onComplete();
        });
        observable.subscribe(consumer-> System.out.println("我处理的元素是："+consumer));
        observable.subscribe(consumer-> System.out.println("我处理的元素是："+consumer));
    }
}
