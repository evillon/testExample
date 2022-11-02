package com.hiper.testexample.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageServiceImpl.class)
class MessageServiceImplTest {

    @Autowired
    private MessageService service;

    @MockBean
    private MessageRepository repository;

    @Mock
    private MessageEntity entityMock;

    @BeforeEach
    void setUp() {
        entityMock = new MessageEntity();
        entityMock.setMessage("test");
        entityMock.setFechaRegistro(new Date());
    }

    @Test
    void addMessage() {
        when(repository.save(entityMock)).thenReturn(entityMock);
        MessageDTO res = service.addMessage("test");
        assertThat(res).isNull();
    }

    @Test
    void getMessage() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertThat(service.getMessage()).isEmpty();
        verify(repository, times(1)).findAll();
    }

    @Test
    void getMessageById() {
        when(repository.findById(1)).thenReturn(Optional.of(entityMock));
        assertThat(service.getMessage()).isEmpty();
        verify(repository, times(1)).findAll();
    }

    @Test
    void updateMessage() {
        MessageDTO dto = new MessageDTO();
        dto.setId(1);
        dto.setMessage("test");
        when(repository.findById(1)).thenReturn(Optional.of(entityMock));
        when(repository.save(entityMock)).thenReturn(entityMock);
        MessageDTO res = service.updateMessage(dto);
        assertThat(res).isNull();
    }

    @Test
    void deleteMessageById() {
       willDoNothing().given(repository).deleteById(1);
       service.deleteMessageById(1);
       verify(repository).deleteById(1);
    }
}