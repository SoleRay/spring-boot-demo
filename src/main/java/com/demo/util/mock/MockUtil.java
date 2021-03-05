package com.demo.util.mock;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockUtil {

    public static <R> List<R> createList(int num, IntFunction<R> function){
        return IntStream.range(0, num).mapToObj(function).collect(Collectors.toList());
    }
}
