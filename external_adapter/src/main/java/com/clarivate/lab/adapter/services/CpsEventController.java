package com.clarivate.lab.adapter.services;

import com.clarivate.lab.adapter.message.BundleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cps")
public class CpsEventController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping(value = "/bundle", method = RequestMethod.POST)
    public String handleCpsEvent(@RequestBody BundleInfo bundleInfo) {
        String responce = String.valueOf(messageSender.sendPipsMessage(bundleInfo));
        return responce;
    }
}
