package com.bingo.controller;

import com.bingo.domain.User;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    @Autowired
    private UserService userService;

    private Response response = new Response();

    @GetMapping(path = "/users")
    public Response list() {
        try {
            response.data = userService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR";
        }
        return response;
    }

    @PostMapping(path = "/user")
    public Response create(User user) {

        ////////
        String idCarton = user.getIdGame() + user.getName();
        user.setCard(idCarton);
        ArrayList<Integer> cardUser = new ArrayList<>();
        ArrayList<Integer> cardCheckUser = new ArrayList<>();
        int colum = 1;
        int min, max;

        for (int i = 0; i < 25; i++) {
            if (colum == 1) {
                min = 1;
                max = 15;
                colum += 1;
            } else if (colum == 2) {
                min = 16;
                max = 30;
                colum += 1;
            } else if (colum == 3) {
                min = 31;
                max = 45;
                colum += 1;
            } else if (colum == 4) {
                min = 46;
                max = 60;
                colum += 1;
            } else {
                min = 61;
                max = 75;
                colum = 1;
            }

            int num = random(min, max);
            if (i == 12) {
                cardUser.add(0);
                cardCheckUser.add(0);
            } else {
                if (cardUser.contains(num)) {
                    i--;
                    colum -=1;
                }else {
                    cardUser.add(num);
                    cardCheckUser.add(null);
                }

            }
        }
        log.info("Valores del carton: {}", cardUser);
        log.info("Valores del carton: {}", cardCheckUser);

        //////////
        userService.save(user);
        response.dataGame.add(user);
        response.dataGame.add(cardUser);
        response.dataGame.add(cardCheckUser);
        return response;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<User> delete(User user) {
        log.info("Usuario a borrar: {}", user);
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/user/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") Long id) {
        log.info("Usuario a modificar: {}", user);
        userService.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

/*    @PatchMapping(path="/user/deleted/{id}")
    public ResponseEntity<User> updateWinner(User gamePlayer, @PathVariable("id") Long id) {
        log.info("Juego a modificar ganador: {}", gamePlayer);
        userService.updateLoser(id,gamePlayer);
        return new ResponseEntity<>(gamePlayer, HttpStatus.OK);
    }*/

}