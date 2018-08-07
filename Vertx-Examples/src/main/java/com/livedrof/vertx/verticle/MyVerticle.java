package com.livedrof.vertx.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import static com.livedrof.vertx.verticle.Queue.EVENT_BUS_TOPIC;

public class MyVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        System.out.println("MyVerticle start");
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
//        router.route().handler(AuthHandler.newInstance())
        router.get("/get/:param1/:param2").handler(this::handleGet);
        router.route("/assets/*").handler(StaticHandler.create("assets"));
        vertx.createHttpServer().requestHandler(router::accept).listen(8009);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("myVerticle stop");
    }

    private void handleGet(RoutingContext context) {
        String param1 = context.request().getParam("param1");
        String param2 = context.request().getParam("param2");
        if (isBlank(param1) || isBlank(param2)) {
            context.response().setStatusCode(400).end();
        }
        JsonObject obj = new JsonObject();
        obj.put("method", "get").put("param1", param1).put("param2", param2);
        vertx.eventBus().publish(EVENT_BUS_TOPIC, "Yay! Someone kicked a ball");
        context.response().putHeader("content-type", "application/json").end(obj.encodePrettily());
    }

    private boolean isBlank(String str) {
        return str == null || "".equals(str);
    }
}
