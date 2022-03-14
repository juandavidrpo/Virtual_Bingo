package com.bingo.service;

import com.bingo.domain.Ballot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Representa la interfaz de balota servicio.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public interface IBallotService {

    public List<Ballot> list();

    public Ballot save(Ballot ballot);

    public Ballot update(Long id, Ballot ballot);

    public void delete(Ballot ballot);

    public Optional<Ballot> findBallot(Ballot ballot);

    public ArrayList<Integer> ballotOut(Long id);
}