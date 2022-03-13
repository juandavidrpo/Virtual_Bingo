package com.bingo.service;

import com.bingo.domain.Ballot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IBallotService {

    public List<Ballot> list();

    public Ballot save(Ballot ballot);

    public Ballot update(Long id, Ballot ballot);

    public void delete(Ballot ballot);

    public Optional<Ballot> findBallot(Ballot ballot);

    public ArrayList<Integer> ballotOut(Long id);
}
