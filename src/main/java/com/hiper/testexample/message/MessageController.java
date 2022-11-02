package com.hiper.testexample.message;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public Integer addMessage(@RequestBody String message){
       return service.addMessage(message).getId();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MessageDTO> getMessage(){
        return service.getMessage();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO getMessageById(@PathVariable Integer id){
        return service.getMessageById(id);
    }

    @PutMapping
    @ResponseBody
    public Integer updateMessage(@RequestBody MessageDTO dto){
        return service.updateMessage(dto).getId();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteMessage(@PathVariable Integer id){
        service.deleteMessageById(id);
    }

}
