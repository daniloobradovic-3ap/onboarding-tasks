package concurrency;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class WTI {

    // a) List - random access by index is needed to pick one employee uniformly at random
    static String pickRandomEmployee(List<String> employees) {
        return employees.get(new Random().nextInt(employees.size()));
    }

    // b) Set - duplicates are automatically rejected, so only unique first names are kept
    static Set<String> uniqueFirstNames(List<String> fullNames) {
        Set<String> firstNames = new HashSet<>();
        for (String name : fullNames) {
            firstNames.add(name.split(" ")[0]);
        }
        return firstNames;
    }

    // c) Map - keys are first names, values are occurrence counts
    static Map<String, Integer> countByFirstName(List<String> fullNames) {
        Map<String, Integer> counts = new HashMap<>();
        for (String name : fullNames) {
            String first = name.split(" ")[0];
            counts.merge(first, 1, Integer::sum);
        }
        return counts;
    }

    // d) Queue (java.util.concurrent) - LinkedBlockingQueue maintains FIFO order and is thread-safe
    static Queue<String> buildWaitingList(List<String> interested) {
        Queue<String> waitingList = new LinkedBlockingQueue<>();
        waitingList.addAll(interested);
        return waitingList;
    }

    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
            "Alice Smith", "Bob Jones", "Alice Brown",
            "Charlie Davis", "Bob Wilson", "Alice Taylor"
        );

        System.out.println("a) Random toy winner:  " + pickRandomEmployee(employees));
        System.out.println("b) Unique first names: " + uniqueFirstNames(employees));
        System.out.println("c) Name counts:        " + countByFirstName(employees));

        Queue<String> waitList = buildWaitingList(
            Arrays.asList("Alice Smith", "Bob Jones", "Charlie Davis")
        );
        System.out.println("d) Next in line: " + waitList.poll());
        System.out.println("   Remaining:    " + waitList);
    }
}