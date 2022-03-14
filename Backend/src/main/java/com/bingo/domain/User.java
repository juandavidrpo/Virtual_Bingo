package com.bingo.domain;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.ArrayList;


@Data
@Entity
@Table(name = "player")

/**
 * Representa la clase usuario.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "game_id")
    private Long idGame;

    @Column(name = "name")
    private String name;

    @Column(name = "card")
    private String card;

    @Column(name = "deleted")
    private String deleted = "0";

    transient private ArrayList<Integer> cardCheck;
}