package com.hiper.testexample.message;

import java.util.List;

public interface MessageService {
    Integer addMessage(String message);
    List<MessageDTO> getMessage();
    MessageDTO getMessageById(Integer id);
    Integer updateMessage(MessageDTO dto);
    void deleteMessageById(Integer id);
}
