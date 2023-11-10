package com.smartubs.msg;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "infobip", url = "https://8gv1vd.api.infobip.com", configuration = MessageClientConfiguration.class)
public interface MessageClient {

    @RequestMapping(method = RequestMethod.POST, value = "/sms/2/text/advanced", produces = "application/json")
    void sendMessage(@RequestBody MessageDTO messageDTO);
}
