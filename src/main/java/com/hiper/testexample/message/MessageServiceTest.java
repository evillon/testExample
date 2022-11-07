package com.hiper.testexample.message;

import java.util.List;

public interface MessageServiceTest {
    MessageDTO addMessage(MessageRequest dto);
    List<MessageDTO> getMessage();
    MessageDTO getMessageById(Integer id);
    MessageDTO updateMessage(MessageDTO dto);
    void deleteMessageById(Integer id);
}
