package com.dcq.controller;

import com.dcq.serverchan.ServerchanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("server")
public class SendServerController {

//    @Autowired
    ServerchanService serverchanService;

    @Value("${spring.serverchan.sckey}")

    @RequestMapping("send")
    public String send(@RequestParam("title") String title, @RequestParam("content")String content){
        serverchanService.sendMessage(title, content);
//        if (result.isSuccess()){
//            //doSomething()
//            return "消息发送成功";
//        }else{
//            //doOtherthing()
//            return "消息发送失败";
//        }
        return "消息发送成功";
    }
}
