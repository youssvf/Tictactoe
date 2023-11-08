package com.example.Tictactoe.infrastructure;

import com.example.Tictactoe.data.DBConnection;
import com.example.Tictactoe.domain.Movimiento;
import com.example.Tictactoe.domain.MovimientoRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MovimientosRepositorySQL implements MovimientoRepository {

    @Override
    public Movimiento colocar(Movimiento movimiento) {
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement("insert into movimientos values(?,?,?); ");
            statement.setInt(1,movimiento.getFila());
            statement.setInt(2,movimiento.getColumna());
            statement.setInt(3,movimiento.getJugador());
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return movimiento;
    }

    @Override
    public void limpiar() {
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            statement.executeUpdate("truncate table movimientos");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
