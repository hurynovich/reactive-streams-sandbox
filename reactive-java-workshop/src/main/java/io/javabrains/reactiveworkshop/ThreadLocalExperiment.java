package io.javabrains.reactiveworkshop;

import java.util.concurrent.*;

public class ThreadLocalExperiment {
    private static final ThreadLocal<String> word = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        word.set("One");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(ThreadLocalExperiment::printWord);
        word.set("Two");
        System.out.println("* " + word.get());
        for (int i = 0; i < 10; i++) {
            executor.execute(ThreadLocalExperiment::printWord);
        }

    }

    private static void printWord() {
        System.out.println("Word is: " + word.get());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
