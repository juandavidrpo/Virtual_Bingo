package com.bingo.dao;

import com.bingo.domain.Ballot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

/**
 * Representa la interfaz del dao balota.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public interface BallotDao extends CrudRepository<Ballot, Long> {

    @Query("select ball.ballot from Ballot ball where ball.idGame = :idGame")
    public ArrayList<Integer> ballotOut(@Param(value = "idGame") Long idGame);

}
