package com.bingo.service;

import com.bingo.domain.Game;

import java.util.List;
import java.util.Optional;

/**
 * Representa la interfaz de juego servicio.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public interface IGameService {

    public List<Game> list();

    public Game save(Game game);

    public Game update(Long id, Game game);

    public void delete(Game game);

    public Optional<Game> findGame(Game game);

    public void updateWinner(Long id, Game game);
}