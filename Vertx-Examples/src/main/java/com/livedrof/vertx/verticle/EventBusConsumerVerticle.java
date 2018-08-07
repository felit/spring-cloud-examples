package com.livedrof.vertx.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;

import static com.livedrof.vertx.verticle.Queue.EVENT_BUS_TOPIC;

public class EventBusConsumerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        EventBus();
    }

    public void EventBus() {
        EventBus eb = vertx.eventBus();
        eb.addInterceptor(context -> {
            Message message = context.message();
//            System.out.println("interceptor from message," + message);
            context.next();

        });
        //注册handlers
        MessageConsumer<String> consumer = eb.consumer(EVENT_BUS_TOPIC);
        consumer.handler(message -> {
//            try {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//            System.out.println("1-I have received a message: " + message.body());
            message.reply("1-how interesting");
        });

        consumer.completionHandler(res -> {
            if (res.succeeded()) {
//                System.out.println("1-The handler registration has reached all nodes");
            } else {
//                System.out.println("Registration failed");
            }
        });
    }
}
