package lamba_vrazy;

import java.util.ArrayList;

public class nechciDoLobez {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int)(Math.random()*150));
        }
        System.out.println(numbers);

        int uniquesAmount = (int)numbers.stream()
                .distinct()
                .count();

        System.out.println(uniquesAmount);

        int uniquesUpper = (int)numbers.stream()
                .distinct()
                .filter(num -> num > 50)
                .count();
        System.out.println("pocet unikatu nad pade: " + uniquesUpper);

        int even = (int)numbers.stream()
                .filter(num -> num % 2 == 0)
                .count();
        System.out.println("pocet sudejch: " + uniquesUpper);

//        numbers.stream()
//                .sorted((num1, num2) -> Integer.compare(num1, num2))
//                .forEach(num -> System.out.print(num + ", "));
//
//        numbers.stream()
//                .sorted(Integer::compareTo)
//                .forEach(System.out::println);

    }
}
