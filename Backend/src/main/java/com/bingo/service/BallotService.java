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
public class BallotService implements IBallotService {

    @Autowired // para inyectar BallotDao
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
