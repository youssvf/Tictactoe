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
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from movimientos");
            while (rs.next()){
                movimientos.add(new Movimiento(rs.getInt("fila"),rs.getInt("columa"),rs.getInt("jugador")));
            }
            model.addAttribute("movimientos",movimientos);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return "tablero";
    }


}
