package com.bingo.dao;

import com.bingo.domain.Ballot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface BallotDao extends CrudRepository<Ballot, Long> {

    @Query("select ball.ballot from Ballot ball where ball.idGame = :idGame")
    public ArrayList<Integer> ballotOut(@Param(value = "idGame") Long idGame);

}
