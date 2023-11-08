package com.example.Tictactoe.rest;

import com.example.Tictactoe.application.MovimientosUseCases;
import com.example.Tictactoe.domain.Movimiento;
import com.example.Tictactoe.infrastructure.MovimientosRepositorySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimientosRestController {
    private MovimientosUseCases movimientosUseCases;

    public MovimientosRestController(){
        this.movimientosUseCases = new MovimientosUseCases(new MovimientosRepositorySQL());
    }

    @PostMapping("/movimiento/{fila}/{columna}/{jugador}")
    public Movimiento colocar(@PathVariable Integer fila, @PathVariable Integer columna, @PathVariable Integer jugador){
        Movimiento movimiento = new Movimiento(fila,columna,jugador);
        return this.movimientosUseCases.colocar(movimiento);
    }

    @PostMapping("/limpiar")
    public void limpiar(){
        this.movimientosUseCases.limpiar();
    }
}
