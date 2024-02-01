package com.enset;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App4 {
    public static void main(String[] args) {
        Consumer<String> consumer = (input) -> {
            System.out.println(input);
        };

        consumer.accept("Hello");

        Supplier<String> supplier = () -> {
            return "azerty";
        };
        System.out.println(supplier.get());

        Function<Integer, Integer> function = a -> {
            return a * 4;
        };
        System.out.println(function.apply(44));

        Predicate<String> predicate = a -> {
           return a.equals("azerty");
        };
        System.out.println(predicate.test("azerty"));
    }
}
