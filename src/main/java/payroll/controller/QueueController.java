package payroll.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Controller
public class QueueController {
    @Autowired
    AmqpTemplate template;

    @RequestMapping("/send/{message}")
    @ResponseBody
    String sendingmessage(@PathVariable String message) throws IOException, TimeoutException {
        template.convertAndSend("test.queue", message);
        return "Сообщение отправлено";
    }


}
