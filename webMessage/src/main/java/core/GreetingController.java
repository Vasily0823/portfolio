package core;

import core.domain.Message;
import core.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepository;
    private String sender;

    @GetMapping("/")
    public String greeting( Map<String, Object> model){
        return "greeting";
    }


    @GetMapping("/login")
    public String login( Map<String, Object> model){
        return "login";
    }



    @GetMapping("/main")
    public String main(@RequestParam String name, Map<String, Object> model){
        Iterable<Message> messages= messageRepository.findAll();
        this.sender=name;
        model.put("name", this.sender);
        model.put("messages", messages);
        return "main";
    }


    @PostMapping("/main")
    public String add(@RequestParam String text, Map<String, Object> model){
        Message message=new Message(text, this.sender);
        messageRepository.save(message);
        Iterable<Message> messages= messageRepository.findAll();
        model.put("name", this.sender);

        model.put("messages", messages);
        return "main";
    }


    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messages;
        if(filter!=null&&!filter.isEmpty()) {
             messages = messageRepository.findBySender(filter);
        }else{
            messages=messageRepository.findAll();
        }
        model.put("name", this.sender);
        model.put("messages", messages);

        return "main";
    }

}

