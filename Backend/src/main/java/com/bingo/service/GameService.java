package com.bingo.service;

import com.bingo.dao.GameDao;
import com.bingo.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {

    @Autowired // para inyectar GameDao
    private GameDao gameDao;

    @Override
    @Transactional(readOnly = true)
    public List<Game> list() {
        return (List<Game>) gameDao.findAll();
    }

    @Override
    @Transactional
    public Game save(Game user) {
        return gameDao.save(user);
    }

    @Override
    @Transactional
    public Game update(Long id, Game game) {
        game.setId(id);
        return gameDao.save(game);
    }

    @Override
    @Transactional
    public void delete(Game game) {
        gameDao.delete(game);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Game> findGame(Game game) {
        return gameDao.findById(game.getId());
    }

    @Transactional
    public void updateWinner(Long id, Game game) {
        gameDao.updateWinner(id, game.getWinner(), game.getBoard());
    }
}
