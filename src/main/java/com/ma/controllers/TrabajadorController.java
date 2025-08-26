package com.ma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ma.beans.Trabajador;
import com.ma.services.TrabajadorService;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @PostMapping
    public String crearTrabajador(@RequestBody Trabajador trabajador) {
        trabajadorService.guardar(trabajador);
        return "Trabajador insertado correctamente";
    }
}
