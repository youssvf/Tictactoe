package com.example.Tictactoe.application;

import com.example.Tictactoe.domain.Movimiento;
import com.example.Tictactoe.domain.MovimientoRepository;

public class MovimientosUseCases {
    public MovimientoRepository movimientoRepository;

    public MovimientosUseCases(MovimientoRepository movimientoRepository){
        this.movimientoRepository = movimientoRepository;
    }

    public Movimiento colocar(Movimiento movimiento){
        return this.movimientoRepository.colocar(movimiento);
    }

    public void limpiar(){
        this.movimientoRepository.limpiar();
    }
}
