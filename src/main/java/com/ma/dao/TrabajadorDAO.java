package com.ma.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ma.beans.Trabajador;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TrabajadorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall insertarTrabajadorCall;

    @PostConstruct
    public void init() {
        insertarTrabajadorCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_INSERTAR_TRABAJADOR");
    }

    public void insertarTrabajador(Trabajador trabajador) {
        Map<String, Object> params = new HashMap<>();
        params.put("p_nombre", trabajador.getNombre());
        params.put("p_apellido", trabajador.getApellido());
        params.put("p_email", trabajador.getEmail());
        params.put("p_telefono", trabajador.getTelefono());
        params.put("p_fecha_contratacion", new java.sql.Date(trabajador.getFechaContratacion().getTime()));
        params.put("p_edad", trabajador.getEdad());

        insertarTrabajadorCall.execute(params);
    }
}
