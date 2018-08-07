package com.livedrof.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class HelloWorldApplication {
    public static void main(String args[]) {
        HttpServer server = Vertx.vertx().createHttpServer();
        server.requestHandler(request -> {

            // This handler gets called for each request that arrives on the
            // server
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            response.end("Hello vertx!");
        });

        server.listen(8080);
    }
}
