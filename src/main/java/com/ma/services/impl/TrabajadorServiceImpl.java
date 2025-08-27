package com.ma.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.beans.Trabajador;
import com.ma.dao.impl.TrabajadorDaoImpl;
import com.ma.services.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorDaoImpl trabajadorDAO;

    @Override
    public void guardar(Trabajador trabajador) {
        trabajadorDAO.insertarTrabajador(trabajador);
    }

	@Override
	public Trabajador buscarPorId(Integer id) {
		return trabajadorDAO.buscarPorIdTrabajador(id);
	}
}
