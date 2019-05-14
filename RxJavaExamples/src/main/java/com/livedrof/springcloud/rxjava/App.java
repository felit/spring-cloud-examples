package com.livedrof.springcloud.rxjava;


import jdk.nashorn.internal.runtime.logging.Logger;
import rx.*;

import java.util.Random;

@Logger
public class App {

    public static void main(String[] args) {
        //Observable 与Subscriber
        createObserver().subscribe(new Subscriber<Integer>() {
            public void onCompleted() {
                System.out.println("on complement!");
            }

            public void onError(Throwable throwable) {
                System.out.println("on Error:" + throwable.getMessage());

            }

            public void onNext(Integer integer) {
                System.out.println("on Next:" + integer);
            }
        });

        // 单个数据生产者
        Single.create(new Single.OnSubscribe<Integer>() {
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                if (!singleSubscriber.isUnsubscribed()) {
                    singleSubscriber.onSuccess(1);
                    //  singleSubscriber.onError(new Throwable("Single error"));
                }
            }
        }).subscribe(new SingleSubscriber<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                System.out.println("SingleSubscriber:" + integer);
            }

            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        });

        //单个事件生产者
        Completable.error(new Throwable("completable error"))
                .subscribe(new CompletableSubscriber() {
                    public void onCompleted() {
                        System.out.println("on complemented");
                    }

                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    public void onSubscribe(Subscription d) {

                    }
                });

        Completable.complete().subscribe(new CompletableSubscriber() {
            public void onCompleted() {
                System.out.println("on complemented");
            }

            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            public void onSubscribe(Subscription d) {

            }
        });
    }

    private static Observable<Integer> createObserver() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i < 5; i++) {
                        int temp = new Random().nextInt(10);
                        if (temp > 8) {
                            subscriber.onError(new Throwable("value > 8"));
                            break;
                        } else {
                            subscriber.onNext(temp);
                        }
                        if (i == 4) {
                            subscriber.onCompleted();
                        }
                    }

                }
            }
        });
    }
}

