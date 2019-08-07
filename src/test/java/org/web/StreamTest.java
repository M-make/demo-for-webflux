package org.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-01
 */
public class StreamTest {
    @AllArgsConstructor
    @Setter
    @Getter
    static class Person {
        String name;
        String value;
    }
    public static void main(String[] args) {
        Stream<Person> personStream = Stream.of(
                new Person("哈哈", "ddd"),
                new Person("ddd", "bb"),
                new Person("ddd", "哈哈")
        );
        Map<String, List<String>> maps = maps(personStream, Person::getName, Person::getValue);
        System.out.println(maps);
    }

    public static <K,V,S> Map<K,List<V>> maps(Stream<S> stream, Function<S,K> key,Function<S,V> value){
        return stream.collect(Collector.<S,Map<K,List<V>>>of(HashMap::new,(map,element)->{
            K mapKey = key.apply(element);
            List<V> vs = map.computeIfAbsent(mapKey, k -> new ArrayList<>());
            vs.add(value.apply(element));
        },(x,y)->x));
    }
}
