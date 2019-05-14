package com.livedrof.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.io.IOException;

public class JacksonTest {
    @Test
    public void testUnSerialization() throws IOException {
        String a = "{\"a\":900,\"next\":\"9000\"}";
        ObjectMapper jsonNode = new ObjectMapper();
        User<Integer> user = jsonNode.readValue(a, User.class);
        System.out.println(user);
    }

    @Data
    @ToString
    static class User<T> {

        private int a;
        private T next;
    }
}
