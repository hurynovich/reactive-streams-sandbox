package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println();
        StreamSources.intNumbersStream()
                .filter(n -> n < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println();
        StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println();
        StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .findFirst()
                .or(() -> Optional.of(-1))
                .ifPresent(System.out::println);

        // Print first names of all users in userStream
        System.out.println();
        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println();
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream()
                        .filter(num -> num.equals(user.getId()))
                        .findAny()
                        .isPresent()
                )
                .map(User::getFirstName)
                .forEach(System.out::println);

    }

}
