package com.example.Tictactoe.domain;

public class Movimiento {
    private Integer fila, columna;
    private Integer jugador;

    public Movimiento(Integer fila, Integer columna, Integer jugador) {
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }

    public Integer getFila() {
        return fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public Integer getJugador() {
        return jugador;
    }
}
