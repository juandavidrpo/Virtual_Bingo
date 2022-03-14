package com.bingo.service;

import com.bingo.dao.BallotDao;
import com.bingo.domain.Ballot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
/**
 * Representa la clase balota servicio.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public class BallotService implements IBallotService {

    /**
     * Implementa los métodos de BallotDao.
     */
    @Autowired
    private BallotDao ballotDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ballot> list() {
        return (List<Ballot>) ballotDao.findAll();
    }

    @Override
    @Transactional
    public Ballot save(Ballot ballot) {
        return ballotDao.save(ballot);
    }

    @Override
    @Transactional
    public Ballot update(Long id, Ballot ballot) {
        ballot.setId(id);
        return ballotDao.save(ballot);
    }

    @Override
    @Transactional
    public void delete(Ballot ballot) {
        ballotDao.delete(ballot);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ballot> findBallot(Ballot ballot) {
        return ballotDao.findById(ballot.getId());
    }

    @Override
    public ArrayList<Integer> ballotOut(Long id) {
        return ballotDao.ballotOut(id);
    }
}