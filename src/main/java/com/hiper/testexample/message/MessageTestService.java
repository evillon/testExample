package com.hiper.testexample.message;

import java.util.List;

public interface MessageTestService {
    MessageTestDTO addMessage(MessageTestRequest dto);
    List<MessageTestDTO> getMessage();
    MessageTestDTO getMessageById(Integer id);
    MessageTestDTO updateMessage(MessageTestDTO dto);
    void deleteMessageById(Integer id);
}
