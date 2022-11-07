package com.hiper.testexample.message;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MessageServiceTestImpl implements MessageServiceTest {

    private final MessageRepository repository;

    private final Gson gson = new Gson();

    private MessageEntity messageEntity = new MessageEntity();

    public MessageServiceTestImpl(MessageRepository repository) {
        this.repository = repository;
    }

    public MessageDTO addMessage(MessageRequest dto) {
        MessageEntity entity = new MessageEntity();
        entity.setMessage(dto.getMessage());
        entity.setFechaRegistro(new Date());
        messageEntity = repository.save(entity);
        log.trace(messageEntity);
        return convertToDTO(messageEntity);
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
    public MessageDTO updateMessage(MessageDTO dto) {

        Optional<MessageEntity> messageEntityOptional = repository.findById(dto.getId());

        if (messageEntityOptional.isEmpty())
            throw new IllegalStateException("No de encontro Informacion solicitada");

        MessageEntity entity = convertToEntity(dto);
        entity.setFechaModifica(new Date());
        entity.setFechaRegistro(messageEntityOptional.get().fechaRegistro);
        messageEntity = repository.save(entity);
        log.trace(messageEntity);
        return convertToDTO(messageEntity);
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
