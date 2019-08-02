package org.flux.webflux;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-08-01
 */
public class StreamTest {
    public static void main(String[] args) {

        class Person{
            String name;
            String value;

            public Person(String name, String value) {
                this.name = name;
                this.value = value;
            }
        }

        Map collect = Arrays.asList(
                new Person("哈哈", "ddd"),
                new Person("ddd", "bb"),
                new Person("ddd", "哈哈")
        ).stream()

                .collect(Collector.<Person, Map<String,Set<String>>>of(HashMap::new, (x, y) -> {
                    Set<String> values = x.computeIfAbsent(y.name, (key) -> {
                        Set<String> objects = new HashSet<>();
                        objects.add(y.value);
                        return objects;
                    });
                    values.add(y.name);
                    x.put(y.name,values);
                }, (x, y) -> {
                    System.out.println();
                    return x;
                }));

        System.out.println(collect);

    }
}
