package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

public class Main {

    public static void main(String[] args) {
        Completable comparable = createCompletable();

        comparable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                System.out.println("Operation is complete");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    private static Completable createCompletable(){
        return Completable.fromAction(deleteItemFromDBAction());
    }

    private static Action deleteItemFromDBAction(){
        return new Action(){
            @Override
            public void run() throws Exception {
                System.out.println("Deleting item from DB");
            }
        };
    }
}