package com.clarivate.lab.pips.services;

import com.clarivate.lab.pips.message.BundleInfo;
import com.clarivate.lab.pips.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BusinessProcessor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Message process(Message message) throws Exception{

        BundleInfo bundle = message.getBundle();

        String pipsStatus = bundle.getPipsStatus();

        //do process message only if active
        if(pipsStatus.equalsIgnoreCase("active")){

            //imitate message process
            logger.info("PIPS started to process a budle...");
            Thread.sleep(500);
            logger.info("PIPS finished process a budle");

            String businessError = bundle.getBusinessError();
            if(businessError != null && !businessError.trim().isEmpty()){
                throw new Exception(businessError);
            }

            String serviceException = bundle.getServiceException();
            if(serviceException != null && !serviceException.trim().isEmpty()){
                throw new Exception(serviceException);
            }
            return message;
        }
        else{
            logger.info("PIPS is inactive, budle will not be processed");
            return null;
        }

    }
}
