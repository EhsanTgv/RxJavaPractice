package org.example;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
//        synchronousObservableExample();
//        asyncObservableExample();
        asyncFlowableExample();
    }

    private static void synchronousObservableExample() {
        Observable.range(1, 1000000)
                .map(id -> new Item(id))
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println("Received MyItem " + item.id + "\n");
                });
    }

    private static void asyncObservableExample() {
        Observable.range(1, 1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println("Received MyItem " + item.id + "\n");
                });

        try {
            sleep(Long.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void asyncFlowableExample(){
        Flowable.range(1,1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println("Received MyItem " + item.id + "\n");
                });

        try {
            sleep(Long.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Item {
    int id;

    public Item(int id) {
        this.id = id;
        System.out.println("Item is created " + id);
    }
}