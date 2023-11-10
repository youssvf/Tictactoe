package com.example.Tictactoe.ssr;

import com.example.Tictactoe.application.MovimientosUseCases;
import com.example.Tictactoe.data.DBConnection;
import com.example.Tictactoe.domain.Movimiento;
import com.example.Tictactoe.infrastructure.MovimientosRepositorySQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovimientosController {
    private MovimientosUseCases movimientosUseCases;

    public MovimientosController(){
        this.movimientosUseCases = new MovimientosUseCases(new MovimientosRepositorySQL());
    }

    @GetMapping("/tablero")
    public String tablero(Model model){
        List<Movimiento> movimientos = new ArrayList<>();
        String[] casillas = new String[9];
        List<Movimiento> movimientos1 = new ArrayList<>();
        List<Movimiento> movimientos2 = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from movimientos order by fila");
            while (rs.next()){
                movimientos.add(new Movimiento(rs.getInt("fila"),rs.getInt("columa"),rs.getInt("jugador")));
            }
            model.addAttribute("movimientos",casillas);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        for (Movimiento m: movimientos){
            switch (m.getJugador()){
                case 1:
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[0] = "X";
                    }
                    if (m.getFila()==1 && m.getColumna() ==2){
                        casillas[1] = "X";
                    }
                    if (m.getFila()==1 && m.getColumna() ==3){
                        casillas[2] = "X";
                    }
                    if (m.getFila()==2 && m.getColumna() ==1){
                        casillas[3] = "X";
                    }
                    if (m.getFila()==2 && m.getColumna() ==2){
                        casillas[4] = "X";
                    }
                    if (m.getFila()==2 && m.getColumna() ==3){
                        casillas[5] = "X";
                    }
                    if (m.getFila()==3 && m.getColumna() ==1){
                        casillas[6] = "X";
                    }
                    if (m.getFila()==3 && m.getColumna() ==2){
                        casillas[7] = "X";
                    }
                    if (m.getFila()==3 && m.getColumna() ==3){
                        casillas[8] = "X";
                    }
                    break;
                case 2:
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[0] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[1] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[2] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[3] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[4] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[5] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[6] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[7] = "O";
                    }
                    if (m.getFila()==1 && m.getColumna() ==1){
                        casillas[8] = "O";
                    }
            }
        }
        return "tablero";
    }


}
