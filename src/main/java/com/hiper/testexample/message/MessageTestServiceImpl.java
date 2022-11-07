package com.hiper.testexample.message;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MessageTestServiceImpl implements MessageTestService {

    private final MessageTestRepository repository;

    private final Gson gson = new Gson();

    private MessageTestEntity messageEntity = new MessageTestEntity();

    @Autowired
    public MessageTestServiceImpl(MessageTestRepository repository) {
        this.repository = repository;
    }

    public MessageTestDTO addMessage(MessageTestRequest dto) {
        MessageTestEntity entity = new MessageTestEntity();
        entity.setMessage(dto.getMessage());
        entity.setFechaRegistro(new Date());
        messageEntity = repository.save(entity);
        log.trace(messageEntity);
        return convertToDTO(messageEntity);
    }

    @Override
    public List<MessageTestDTO> getMessage() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MessageTestDTO getMessageById(Integer id) {
        return repository.findById(id).stream().findFirst().map(this::convertToDTO).orElseThrow();
    }

    @Override
    public MessageTestDTO updateMessage(MessageTestDTO dto) {

        Optional<MessageTestEntity> messageEntityOptional = repository.findById(dto.getId());

        if (messageEntityOptional.isEmpty())
            throw new IllegalStateException("No de encontro Informacion solicitada");

        MessageTestEntity entity = convertToEntity(dto);
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

    private MessageTestEntity convertToEntity(MessageTestDTO dto) {
        return gson.fromJson(gson.toJson(dto), MessageTestEntity.class);
    }

    private MessageTestDTO convertToDTO(MessageTestEntity entity) {
        return gson.fromJson(gson.toJson(entity), MessageTestDTO.class);
    }

}
