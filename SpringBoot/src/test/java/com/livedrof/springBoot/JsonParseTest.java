package com.livedrof.springBoot;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class JsonParseTest {

    public static void main(String[] args) throws JsonProcessingException {
        Monitoring.begin();
        List<Corp> list = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(fullObject(Corp.class));
        }
        Monitoring.end("生成数据");

        Monitoring.begin();
        jackson(list);
        Monitoring.end("Jackson");

        Monitoring.begin();
        fastjson(list);
        Monitoring.end("fastjson");

    }

    public static void fastjson(List<Corp> list) {
        for (Corp corp : list) {
            String string = JSON.toJSONString(corp);
        }
    }

    public static void jackson(List<Corp> list) throws JsonProcessingException {
        for (Corp corp : list) {
            String string = new ObjectMapper().writeValueAsString(corp);
        }
    }

    /**
     * 填充一个对象（一般用于测试）
     */
    public static <T> T fullObject(Class<T> cl) {
        T t = null;
        try {
            t = cl.newInstance();
            Method methods[] = cl.getMethods();
            for (Method method : methods) {
                // 如果是set方法,进行随机数据的填充
                if (method.getName().indexOf("set") == 0) {
                    Class param = method.getParameterTypes()[0];
                    if (param.equals(String.class)) {
//                        method.invoke(t, randomCodes(5));
                    } else if (param.equals(Short.class)) {
                        method.invoke(t, (short) new Random().nextInt(5));
                    } else if (param.equals(Float.class)) {
                        method.invoke(t, new Random().nextFloat());
                    } else if (param.equals(Double.class)) {
                        method.invoke(t, new Random().nextDouble());
                    } else if (param.equals(Integer.class)) {
                        method.invoke(t, new Random().nextInt(10));
                    } else if (param.equals(Long.class)) {
                        method.invoke(t, new Random().nextLong());
                    } else if (param.equals(Date.class)) {
                        method.invoke(t, new Date());
                    } else if (param.equals(Timestamp.class)) {
                        method.invoke(t, new Timestamp(System.currentTimeMillis()));
                    } else if (param.equals(java.sql.Date.class)) {
                        method.invoke(t, new java.sql.Date(System.currentTimeMillis()));
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}
