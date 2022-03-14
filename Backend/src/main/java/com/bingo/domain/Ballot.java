package com.bingo.domain;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;


@Data
@Entity
@Table(name = "ballot")
/**
 * Representa la clase balota.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public class Ballot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ballot")
    private Long id;

    @Column(name = "game_id")
    private Long idGame;

    @Column(name = "ballot")
    private Long ballot;

}
