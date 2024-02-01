package com.enset.business;
@FunctionalInterface
public interface Condition<T> {
    boolean test(T t);
}
