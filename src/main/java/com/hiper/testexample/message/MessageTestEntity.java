package com.hiper.testexample.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mensaje")
@Getter
@Setter
@RequiredArgsConstructor
public class MessageTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String message;
    Date fechaRegistro;
    Date fechaModifica;

}
