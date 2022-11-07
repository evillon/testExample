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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageTestServiceImpl.class)
class MessageServiceImplTest {

    @Autowired
    private MessageTestService service;

    @MockBean
    private MessageTestRepository repository;

    @Mock
    private MessageTestEntity entityMock;

    @Mock
    private MessageTestRequest request;

    @Mock
    private MessageTestDTO dto;

    @BeforeEach
    void setUp() {
        entityMock = new MessageTestEntity();
        entityMock.setId(1);
        entityMock.setMessage("test");
        entityMock.setFechaRegistro(new Date());
        entityMock.setFechaModifica(new Date());

        request = new MessageTestRequest();
        request.setMessage("test");

        dto = new MessageTestDTO();
        dto.setId(1);
        dto.setMessage("test");

    }

    @Test
    void addMessage() {
        when(repository.save(entityMock)).thenReturn(entityMock);
        MessageTestDTO res = service.addMessage(request);
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
        assertThat(service.getMessageById(1)).isNotNull();
        verify(repository, times(1)).findById(1);
    }

    @Test
    void updateMessage() {
        when(repository.findById(1)).thenReturn(Optional.of(entityMock));
        when(repository.save(entityMock)).thenReturn(entityMock);
        MessageTestDTO res = service.updateMessage(dto);
        assertThat(res).isNull();
    }

    @Test
    void deleteMessageById() {
       willDoNothing().given(repository).deleteById(1);
       service.deleteMessageById(1);
       verify(repository).deleteById(1);
    }

    @Test
    void updateExceptionValue() {
        when(repository.save(entityMock)).thenReturn(entityMock);
        when(repository.findById(1)).thenReturn(Optional.empty());
        dto.setId(null);
        assertThrows(IllegalStateException.class,()->service.updateMessage(dto));
    }
}