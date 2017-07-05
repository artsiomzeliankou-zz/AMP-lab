package com.clarivate.lab.adapter.services;

import com.clarivate.lab.adapter.message.BundleInfo;
import com.clarivate.lab.adapter.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageSender {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String PIPS_INPUT_QUEQE = "pips_input_queue";

    @Autowired
    @Qualifier(value = "kafkaTemplate")
    private KafkaTemplate<String, Message> kafkaTemplate;

    public long sendPipsMessage(BundleInfo bundleInfo) {
        Message message = createMessage(bundleInfo);

        this.kafkaTemplate.send(PIPS_INPUT_QUEQE, message);
        logger.info("Message sent to pips queue: " + "\n" + message);
        return message.getId();
    }

    private Message createMessage(BundleInfo bundleInfo){
        Message message = new Message();
        message.setBundle(bundleInfo);
        return message;
    }

}
