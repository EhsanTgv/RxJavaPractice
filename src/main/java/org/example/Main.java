package org.example;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;

import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(2, 5);

        observable.subscribe(item -> {

        });

        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

        intervalObservable.subscribe(item -> {

        });

        Observable<Long> timerObservable = Observable.timer(5, TimeUnit.SECONDS);

        timerObservable.subscribe(item -> {
            System.out.println("5 seconds passed");
        });

        Action action = () -> System.out.println("Hello world");

        Completable completable = Completable.fromAction(action);

        completable.subscribe(() -> {
            System.out.println("Action ends");
        });

        new Scanner(System.in).nextLine();
    }
}