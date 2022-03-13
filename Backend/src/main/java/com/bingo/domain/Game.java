package com.bingo.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private Long id;

    @Column(name = "state")
    private String inProgress = "1";

    @Column(name = "winner")
    private String winner;

    @Column(name = "board")
    private String board;

    @Column(name = "create_at")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createDate;

}
