package com.livedrof.springStarter.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class Producer {

    /*
     * Constructs a client instance with your account for accessing DefaultMQProducer
     */
    private static DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
    private static int initialState = 0;

    private Producer() {

    }

    public static DefaultMQProducer getDefaultMQProducer() {
        if (producer == null) {
            producer = new DefaultMQProducer("ProducerGroupName");
        }

        if (initialState == 0) {
            producer.setNamesrvAddr(Utils.NAME_SERVER_ADDRESS);
            try {
                producer.start();
            } catch (MQClientException e) {
                e.printStackTrace();
                return null;
            }

            initialState = 1;
        }

        return producer;
    }
}
