package com.hiper.testexample.message;

import java.util.List;

public interface MessageService {
    MessageDTO addMessage(String message);
    List<MessageDTO> getMessage();
    MessageDTO getMessageById(Integer id);
    MessageDTO updateMessage(MessageDTO dto);
    void deleteMessageById(Integer id);
}
