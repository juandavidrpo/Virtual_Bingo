package com.bingo.controller;

import com.bingo.domain.Ballot;

import com.bingo.service.BallotService;
import com.bingo.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class BallotController {

    @Autowired
    private BallotService ballotService;

    private Response response = new Response();

    @GetMapping(path = "/ballots")
    public Response list() {
        try {
            response.data = ballotService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    @PostMapping(path="/ballot")
    public Response create(Ballot ballot) {
        log.info("balota de Juego a crear: {}", ballot);

        ///logica anunciar balota
        ArrayList<Integer> ballotout = new ArrayList<>();
        ArrayList<Integer> ballots = new ArrayList<>();
        ballotout = ballotService.ballotOut(ballot.getIdGame());
        for(int i = 1; i <= 75; i++){
            ballots.add(i);
        }

        ballotout.stream().forEach(b -> {
            ballots.remove(ballots.indexOf(b));
        });

        int indiceAleatorio = random(0, ballots.size() - 1);
        int newBallot = ballots.get(indiceAleatorio);
        ballot.setBallot((long) newBallot);
        ballotout.add(newBallot);

        String letter = "";
        if(newBallot < 16) {
            letter = "B";
        }else if(newBallot < 31) {
            letter = "I";
        }else if(newBallot < 46) {
            letter = "N";
        }else if(newBallot < 61) {
            letter = "G";
        }else{
            letter = "O";
        }

        log.info("Balotas anunciadas: {}", ballotout);
        log.info("Balota total: {}", ballots);
        log.info("Nueva balota : {}",letter + newBallot);
        ///fin logica anunciar balota

        /**
         * guardando información en la database
         */
        ballotService.save(ballot);
        /**
         * guardando datos a enviar al front
         */
        response.dataGame.add(ballot);
        response.dataGame.add(ballotout);
        response.dataGame.add(letter);
        response.dataGame.add(newBallot);
        return response;
    }

    @DeleteMapping(path = "/ballot/{id}")
    public ResponseEntity<Ballot> delete(Ballot ballot) {
        log.info("Ballot a borrar: {}", ballot);
        ballotService.delete(ballot);
        return new ResponseEntity<>(ballot, HttpStatus.OK);
    }

    @PutMapping(path = "/ballot/{id}")
    public ResponseEntity<Ballot> update(Ballot ballot, @PathVariable("id") Long id) {
        log.info("Usuario a modificar: {}", ballot);
        ballotService.update(id, ballot);
        return new ResponseEntity<>(ballot, HttpStatus.OK);
    }
}