package com.livedrof.springcloud.hystrix.basic;

import rx.Observable;
import rx.Observer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestHelloWorldHystrixObservableCommand {
    public static void main(String args[]) {
        List<Integer> in = new LinkedList<Integer>();
        in.add(2);
        in.add(3);

        Observable<HelloWorldHystrixObservableCommand.NumberWord> hotObservable = new HelloWorldHystrixObservableCommand("observable",in).observe();
        hotObservable.subscribe(new Observer<HelloWorldHystrixObservableCommand.NumberWord>() {

            // 先执行onNext再执行onCompleted
            // @Override
            public void onCompleted() {
                System.out.println("hotObservable of ObservableCommand completed");
            }

            // @Override
            public void onError(Throwable e) {

                System.out.println("hotObservable of ObservableCommand error");
                e.printStackTrace();
            }

            // @Override
            public void onNext(HelloWorldHystrixObservableCommand.NumberWord v) {
                System.out.println("hotObservable of ObservableCommand onNext: " + v.getWord());
            }

        });
    }

}