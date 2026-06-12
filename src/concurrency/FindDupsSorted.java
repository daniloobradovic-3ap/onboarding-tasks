package concurrency;

import java.util.SortedSet;
import java.util.TreeSet;

public class FindDupsSorted {
    public static void main(String[] args) {
        SortedSet<String> s = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (String a : args) {
            if (!s.add(a)) {
                System.out.println("Duplicate detected: " + a);
            }
        }
        System.out.println(s.size() + " distinct words: " + s);
    }
}