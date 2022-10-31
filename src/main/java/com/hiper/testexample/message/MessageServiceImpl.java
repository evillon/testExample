package com.hiper.testexample.message;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    private final Gson gson = new Gson();

    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    public Integer addMessage(String message) {
        MessageEntity entity = new MessageEntity();
        entity.setMessage(message);
        entity.setFechaRegistro(new Date());
        return repository.save(entity).getId();
    }

    @Override
    public List<MessageDTO> getMessage() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MessageDTO getMessageById(Integer id) {
        return repository.findById(id).stream().findFirst().map(this::convertToDTO).orElseThrow();
    }

    @Override
    public Integer updateMessage(MessageDTO dto) {
        MessageEntity entity = convertToEntity(dto);
        entity.setFechaModifica(new Date());
        return repository.save(entity).getId();
    }

    @Override
    public void deleteMessageById(Integer id) {
        repository.deleteById(id);
    }

    private MessageEntity convertToEntity(MessageDTO dto) {

        return gson.fromJson(gson.toJson(dto), MessageEntity.class);
    }

    private MessageDTO convertToDTO(MessageEntity entity) {

        return gson.fromJson(gson.toJson(entity), MessageDTO.class);
    }

}
