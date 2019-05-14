package com.livedrof.springcloud.rxjava;


import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OperatorTest {
    @Test
    public void testRange() {
        Observable.range(10, 5).subscribe(new Action1<Integer>() {

            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    public void testDefer() {
        getDefer().subscribe(new Action1<Long>() {
            public void call(Long aLong) {
                System.out.println("defer:" + aLong);
            }
        });
        getJust().subscribe(new Action1<Long>() {
            public void call(Long aLong) {
                System.out.println("just:" + aLong);
            }
        });
    }

    @Test
    public void testFrom() {
        Integer[] arrays = {0, 1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 5; i++) {
            list.add(i);
        }

        Observable.from(arrays).subscribe(new Action1<Integer>() {
            public void call(Integer integer) {
                System.out.println("FromArray:" + integer);
            }
        });

        Observable.from(list).subscribe(new Action1<Integer>() {
            public void call(Integer integer) {
                System.out.println("FromIterable:" + integer);
            }
        });
    }

    @Test
    public void testInterval() {
        Observable.interval(1, TimeUnit.SECONDS) .subscribe(new Subscriber<Long>() {
            public void onCompleted() {
                System.out.println("on completed");
            }

            public void onError(Throwable e) {
                System.out.println("on error:" + e.getMessage());
            }

            public void onNext(Long aLong) {
                System.out.println("on next:" + aLong);
            }
        });

    }

    private Observable<Long> getDefer() {
        return Observable.defer(new Func0<Observable<Long>>() {
            public Observable<Long> call() {
                return getJust();
            }
        });
    }


    private Observable<Long> getJust() {
        return Observable.just(System.currentTimeMillis());
    }
}
