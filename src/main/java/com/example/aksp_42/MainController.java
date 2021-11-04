package com.example.aksp_42;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public MessageOutput send(Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new MessageOutput(message.getFrom(), message.getText(), time);
    }
}
