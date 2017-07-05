package com.clarivate.lab.contentservice.services;

import com.clarivate.lab.contentservice.message.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String CONTENT_SERVICE_INPUT_QUEQE = "content_service_input_queue";
    private final static String NEXT_SERVICE_QUEUE = "next_service_input_queue";
    private final static String BUSINESS_ERRORS_QUEQE = "business_errors_queue";

    @Autowired
    @Qualifier(value = "kafkaTemplate")
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Autowired
    private BusinessProcessor processor;

    @KafkaListener(topics = CONTENT_SERVICE_INPUT_QUEQE)
    public void processMessage(ConsumerRecord<String, Message> cr) throws Exception {
        logger.info("Content service received new message: " + cr.toString());

        Message message = cr.value();

        try{

            Message result = processor.process(message);
            if(result != null){
                this.kafkaTemplate.send(NEXT_SERVICE_QUEUE, message);
                logger.info("Message sent to next service queue: " + "\n" + message);
            }else{
                logger.info("No message was sent to next service queue: ");
            }

        }catch(Exception e){
            //need to separate exceptions
            this.kafkaTemplate.send(BUSINESS_ERRORS_QUEQE, message);
            logger.info("Message sent to adapter error queue: " + "\n" + message);
        }

    }

}
