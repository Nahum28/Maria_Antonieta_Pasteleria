package com.ma.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.beans.Trabajador;
import com.ma.dao.TrabajadorDAO;
import com.ma.services.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorDAO trabajadorDAO;

    @Override
    public void guardar(Trabajador trabajador) {
        trabajadorDAO.insertarTrabajador(trabajador);
    }
}
