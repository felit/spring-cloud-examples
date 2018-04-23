package com.livedrof.springcloud.hystrix.basic;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.functions.Func1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorldHystrixObservableCommand  extends HystrixObservableCommand<HelloWorldHystrixObservableCommand.NumberWord> {
    private final List<Integer> numbers;

    // in the real world you'd probably want to replace this very simple code by using ICU or similar
    static Map<Integer, String> dict = new HashMap<Integer, String>(11);
    static
    {
        dict.put(0, "zero");
        dict.put(1, "one");
        dict.put(2, "two");
        dict.put(3, "three");
        dict.put(4, "four");
        dict.put(5, "five");
        dict.put(6, "six");
        dict.put(7, "seven");
        dict.put(8, "eight");
        dict.put(9, "nine");
        dict.put(10, "ten");
    }

    protected HelloWorldHystrixObservableCommand(String group,final List<Integer> numbers) {
        super(HystrixCommandGroupKey.Factory.asKey(group));
        this.numbers = numbers;
    }

    @Override
    protected Observable<NumberWord> construct() {
        System.out.println("construct! thread:" + Thread.currentThread().getName());
        Thread.dumpStack();
        return Observable.from(numbers).map(new Func1<Integer, NumberWord>()
        {

            public NumberWord call(final Integer number)
            {
                System.out.println("call! thread:" + Thread.currentThread().getName());
                return new NumberWord(number, dict.get(number));
            }

        });

    }

    @Override
    protected Observable<NumberWord> resumeWithFallback() {
        return super.resumeWithFallback();
    }

    static class NumberWord
    {
        private final Integer number;
        private final String word;

        public NumberWord(final Integer number, final String word)
        {
            super();
            this.number = number;
            this.word = word;
        }

        public Integer getNumber()
        {
            return number;
        }

        public String getWord()
        {
            return word;
        }
    }


}
