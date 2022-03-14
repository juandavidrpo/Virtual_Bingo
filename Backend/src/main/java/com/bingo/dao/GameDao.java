package com.bingo.dao;

import com.bingo.domain.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Representa la interfaz del dao de juego.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public interface GameDao extends CrudRepository<Game, Long> {

    @Modifying
    @Query("update Game gam set gam.inProgress = '0', gam.winner = :winner, gam.board = :board WHERE gam.id = :id")
    public void updateWinner(@Param(value = "id") Long id,
                             @Param(value = "winner") String winner,
                             @Param(value = "board") String board);
}

