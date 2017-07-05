package com.clarivate.lab.adapter.utils;

import com.clarivate.lab.adapter.message.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MessageSerializer implements Serializer<Message>, Deserializer<Message> {


    @Override
    public byte[] serialize(String topic, Message message) {
        if (message == null) {
            return null;
        }
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(message).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public Message deserialize(String arg0, byte[] value) {
        if (value == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        Message user = null;
        try {
            user = mapper.readValue(value, Message.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public void close() {

    }

}
