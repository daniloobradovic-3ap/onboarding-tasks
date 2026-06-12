package concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomArgs {
    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        Collections.shuffle(argList);

        System.out.println("Enhanced for loop:");
        for (String arg : argList) {
            System.out.println(arg);
        }

        System.out.println("\nStreams:");
        argList.forEach(System.out::println);
    }
}