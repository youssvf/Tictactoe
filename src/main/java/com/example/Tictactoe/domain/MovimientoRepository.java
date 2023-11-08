package com.example.Tictactoe.domain;

public interface MovimientoRepository {
    public Movimiento colocar(Movimiento movimiento);
    public void limpiar();
}
