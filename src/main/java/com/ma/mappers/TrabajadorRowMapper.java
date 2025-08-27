package com.ma.mappers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ma.beans.Trabajador;

public class TrabajadorRowMapper implements RowMapper<Trabajador> {
    @Override
    public Trabajador mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trabajador t = new Trabajador();
        t.setNombre(rs.getString("nombre"));
        t.setApellido(rs.getString("apellido"));
        t.setEmail(rs.getString("email"));
        t.setTelefono(rs.getString("telefono"));
        Date fechaSql = rs.getDate("fecha_contratacion");
        if (fechaSql != null) {
            t.setFechaContratacion(fechaSql.toLocalDate());
        }   
        t.setEdad(rs.getInt("edad"));
        return t;
    }
}