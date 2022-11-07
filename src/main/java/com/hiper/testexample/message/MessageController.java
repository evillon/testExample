package com.hiper.testexample.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    private final MessageServiceTest service;

    @Autowired
    public MessageController(MessageServiceTestImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MessageDTO addMessage(@RequestBody MessageRequest dto){
       return service.addMessage(dto);
    }

    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MessageDTO> getMessage(){
        return service.getMessage();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO getMessageById(@PathVariable Integer id){
        return service.getMessageById(id);
    }

    @PutMapping(value = "/put")
    @ResponseBody
    public Integer updateMessage(@RequestBody MessageDTO dto){
        return service.updateMessage(dto).getId();
    }

    @DeleteMapping(value = "/get/{id}")
    @ResponseBody
    public void deleteMessage(@PathVariable Integer id){
        service.deleteMessageById(id);
    }

}
