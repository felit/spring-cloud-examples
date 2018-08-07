package com.livedrof.vertx.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

import static com.livedrof.vertx.verticle.Queue.EVENT_BUS_TOPIC;

public class WorkerVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
        EventBus eb = vertx.eventBus();
        //注册handlers
        MessageConsumer<String> consumer = eb.consumer(EVENT_BUS_TOPIC);
        consumer.handler(message -> {
//            try {
////                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("WorkerVerticle 1-I have received a message: " + message.body());
            message.reply("1-how interesting WorkerVerticle");
        });
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }
}
