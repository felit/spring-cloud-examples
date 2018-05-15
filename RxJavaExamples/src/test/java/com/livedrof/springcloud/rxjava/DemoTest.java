package com.livedrof.springcloud.rxjava;

import rx.Observer;

public class DemoTest {
    public void test() {

        Observer<String> observer = new Observer<String>() {
            public void onNext(String s) {
                System.out.println("onNext:传递面包事件");
            }

            public void onCompleted() {
                System.out.println("onCompleted:传递面包事件完成");
            }

            public void onError(Throwable e) {
                System.out.println("onError:传递面包事件出错了");
            }
        };
    }
}
