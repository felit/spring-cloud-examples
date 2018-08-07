package com.livedrof.vertx.verticle;

import io.vertx.core.Vertx;

public class VertStart {
    public static void main(String args[]) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle());
        vertx.deployVerticle(new MyVerticle());
        vertx.deployVerticle(new MyVerticle());
        vertx.deployVerticle(new MyVerticle());
        vertx.deployVerticle(new EventBusConsumerVerticle());
        vertx.deployVerticle(new WorkerVerticle());
    }
}
