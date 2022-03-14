package com.bingo.controller;

import com.bingo.domain.Game;
import com.bingo.domain.User;
import com.bingo.service.BallotService;
import com.bingo.service.GameService;
import com.bingo.service.UserService;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")

/**
 * Representa la clase del controlador del juego.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private BallotService ballotService;

    @Autowired
    private UserService userService;


    private Response response = new Response();

    Game game = new Game();

    /**
     * Representa el método GET.
     * @return información del juego.
     */
    @GetMapping(path = "/games")
    public Response list() {
        try {
            response.data = gameService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    /**
     * Representa el método POST.
     * @param game
     * @return un juego creado.
     */
    @PostMapping(path="/game")
    public ResponseEntity<Game> create(Game game) {
        log.info("Juego a crear: {}", game);
        gameService.save(game);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    /**
     * Representa el método DELETE.
     * @param game
     * @return el borrado de un juego.
     */
    @DeleteMapping(path = "/game/{id}")
    public ResponseEntity<Game> delete(Game game) {
        log.info("Juego a borrar: {}", game);
        gameService.delete(game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    /**
     * Representa el método PUT.
     * @param game
     * @param id
     * @return la actualización del juego.
     */
    @PutMapping(path = "/game/{id}")
    public ResponseEntity<Game> update(Game game, @PathVariable("id") Long id) {
        log.info("Juego a modificar: {}", game);
        gameService.update(id, game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    /**
     * Representa el método PATCH.
     * @param game
     * @param id
     * @return la actualización del ganador.
     */
    @PatchMapping(path="/game/winner/{id}")
    public ResponseEntity<Game> updateWinner(Game game, @PathVariable("id") Long id) {
        log.info("Modificar ganador: {}", game);
        gameService.updateWinner(id,game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    /**
     * Representa el método POST.
     * @param user
     * @param id
     * @return la validación del ganador.
     */
    @PostMapping(path="/game/bingo/{id}")
    public Response win(User user, @PathVariable("id") Long id) {
        log.info("Juego de jugador: {}", user);
        log.info("cardCheck: {}", user.getCardCheck());
        user.setIdGame(id);

        ArrayList<Integer> cardCheck = user.getCardCheck();
        ArrayList<Integer> ballotout;

        ballotout = ballotService.ballotOut(id);
        ballotout.add(0);
        int lines[][] = {
                {0,1,2,3,4}, {5,6,7,8,9}, {10,11,12,13,14}, {15,16,17,18,19}, {20,21,22,23,24},
                {0,5,10,15,20}, {1,6,11,16,21}, {2,7,12,17,22}, {3,8,13,18,23}, {4,9,14,19,24},
                {0,6,12,18,24}, {4,8,12,16,20},
                {0,4,12,20,24}
        };
        log.info("balotas anunciadas: {}", ballotout);

        boolean win = false;
        String lineWin = "";
        for(int i = 0; i < lines.length; i++){
            int a = lines[i][0];
            int b = lines[i][1];
            int c = lines[i][2];
            int d = lines[i][3];
            int e = lines[i][4];

            if(ballotout.contains(cardCheck.get(a))
                    && ballotout.contains(cardCheck.get(b))
                    && ballotout.contains(cardCheck.get(c))
                    && ballotout.contains(cardCheck.get(d))
                    && ballotout.contains(cardCheck.get(e))){
                log.info("a: {}", cardCheck.get(a));
                log.info("b: {}", cardCheck.get(b));
                log.info("c: {}", cardCheck.get(c));
                log.info("d: {}", cardCheck.get(d));
                log.info("e: {}", cardCheck.get(e));

                win = true;
                if(i < 5){
                    lineWin = "Horizontal";
                }else if(i < 10){
                    lineWin = "Vertical";
                }else if(i < 12){
                    lineWin = "Diagonal";
                }else{
                    lineWin = "Esquinas";
                }
            }
        }

        if(win){
            log.info("Ganador: {}", lineWin);
            game.setId(id);
            game.setWinner(user.getName());
            game.setBoard(user.getCard());
            gameService.updateWinner(id, game);
        }else{
            log.info("Jugador perdio: {}");
        }
        response.dataGame.removeAll(response.dataGame);
        response.dataGame.add(win);
        response.dataGame.add(lineWin);
        response.dataGame.add(user);
        return response;
    }
}