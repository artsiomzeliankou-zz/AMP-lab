package com.clarivate.lab.contentservice.services;

import com.clarivate.lab.contentservice.message.BundleInfo;
import com.clarivate.lab.contentservice.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BusinessProcessor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Message process(Message message) throws Exception{

        BundleInfo bundle = message.getBundle();

        int scholarlyItemsNumber = bundle.getScholarlyItemsNumber();
        int publicationArtifactsNumber = bundle.getPublicationArtifactsNumber();

        if(scholarlyItemsNumber > 0) {

            if (publicationArtifactsNumber > 0) {
                //imitate message process
                logger.info("Content service started to process a budle...");
                Thread.sleep(600);
                logger.info("Content service processed " + publicationArtifactsNumber + " artifacts");
            }
        }
        else{
            logger.info("No items to process");
        }

        return message;
    }
}
