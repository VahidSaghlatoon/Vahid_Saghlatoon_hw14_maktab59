package com.vahidsaghlatoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
interface Calculate<T> {
    T average(T number1, T number2);
}

public class Main {

    public static void main(String[] args) {

        //q1
        Calculate<Double> average = (x, y) -> (x + y) / 2;
        System.out.println("average is : " + average.average(5.5, 6.5));

        //q2
        Predicate<String> predicate = word -> word.charAt(0) == word.charAt(word.length() - 1);
        System.out.println(predicate.test("hih"));
        System.out.println(predicate.test("hi"));

        //q3
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(5);
        nums.add(1);
        nums.stream()
                .filter(val -> val > 4)
                .forEach(x -> System.out.println("result is : " + x));
        //q4-A
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("man", "baby", "child", "tree", "cup", "grass"));

        Map<Integer, List<String>> groupByLettersCount = arrayList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("group by letter count : " + groupByLettersCount);
        //q4-B
        Map<Integer, Long> countOfWordInLetterCountGroup = arrayList.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("number of word in ever letter count group : " + countOfWordInLetterCountGroup);
    }
}
