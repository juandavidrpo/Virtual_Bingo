package com.bingo.util;

import java.util.ArrayList;

/**
 * Representa la clase Response.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public class Response {
    public Boolean error = false;
    public String message = "";
    public String status = "OK";
    public Object data;
    public ArrayList<Object> dataGame = new ArrayList<>();
}
