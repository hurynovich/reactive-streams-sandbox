package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Signal;

import java.io.IOException;
import java.time.Duration;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
        System.out.println("Start creating first.");
        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        var r = ReactiveSources.intNumbersFlux()
                .subscribe(System.out::println);
        System.out.println("Subscribed first.");

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux()
//                .log()
                .toStream(3)
                        .forEach(System.out::println);
//                .map(User::getFirstName)
//                .subscribe((n) -> System.out.println(Thread.currentThread().getName() + " " + n));

        System.out.println("Press a key to end " + r.isDisposed());
        System.in.read();
        System.out.println("Press a key to end " + r.isDisposed());
    }

}
