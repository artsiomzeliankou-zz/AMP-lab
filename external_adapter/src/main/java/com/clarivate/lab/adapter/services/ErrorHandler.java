package com.clarivate.lab.adapter.services;

import com.clarivate.lab.adapter.message.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String BUSINESS_ERRORS_QUEQE = "business_errors_queue";
    private final static String SERVICES_EXCEPTIONS_QUEQE = "services_exceptions_queue";

    @KafkaListener(topics = BUSINESS_ERRORS_QUEQE)
    public void processError(ConsumerRecord<String, Message> cr) throws Exception {
        logger.info("Adapter received error message: " + cr.toString());
    }

    @KafkaListener(topics = SERVICES_EXCEPTIONS_QUEQE)
    public void processException(ConsumerRecord<String, Message> cr) throws Exception {
        logger.info("Adapter received exception message: " + cr.toString());
    }
}
