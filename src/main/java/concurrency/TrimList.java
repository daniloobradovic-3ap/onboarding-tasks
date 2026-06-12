package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrimList {
    static void trimElements(List<String> list) {
        list.replaceAll(String::trim);
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("  hello ", " world ", "  java  "));
        System.out.println("Before: " + words);
        trimElements(words);
        System.out.println("After:  " + words);
    }
}