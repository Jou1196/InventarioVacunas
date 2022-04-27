/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jarias.inventario.demo.controllers;

import com.jarias.inventario.demo.entity.Empleados;
import com.jarias.inventario.demo.entity.InfoEmpleado;
import com.jarias.inventario.demo.services.IInfoEmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@CrossOrigin
@RestController
@RequestMapping("/info")
public class InfoEmpleadoController {

    @Autowired
    IInfoEmpleadoService infoEmpleadoService;

    @Operation(summary = "Lista la informacion de los empleados")
    @GetMapping("/")
    public List<InfoEmpleado> index() {
        return infoEmpleadoService.findAll();
    }

    @Operation(summary = "Lista la informacion de los empleados por id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InfoEmpleado show(@PathVariable Long id) {
        return infoEmpleadoService.findById(id);
    }

    @Operation(summary = "Lista la informacion de los empleados por estado de la vacuna podria ser Si O No ")
    @CrossOrigin
    @GetMapping("/estado")
    public List<InfoEmpleado> estado(@RequestParam("estado") String estado) {
        return infoEmpleadoService.findEstadoVacuna(estado);

    }

    @Operation(summary = "Lista la informacion de los empleados por tipo de la vacuna podria ser Sinovac ")
    @CrossOrigin
    @GetMapping("/tipo")
    public List<InfoEmpleado> tipo(@RequestParam("tipo") String tipo) {
        return infoEmpleadoService.findTipoVacuna(tipo);

    }

    @Operation(summary = "Lista la informacion de los empleados por fecha de la vacuna podria ser entres 2021-06-25 a 2023-06-25 ")

    @CrossOrigin
    @GetMapping("/fecha")
    public List<InfoEmpleado> fecha(@RequestParam("fecha") String fecha, @RequestParam("fecha2") String fecha2) {
        return infoEmpleadoService.findFecha(fecha, fecha2);

    }

    @Operation(summary = "Crea nueva informacion del empleado a traves de su cedula  ")

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public InfoEmpleado create(@RequestBody InfoEmpleado infoEmpleado) {
        return infoEmpleadoService.save(infoEmpleado);
    }

    @Operation(summary = "Actualiza informacion del empleado  ")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public InfoEmpleado update(@RequestBody InfoEmpleado infoEmpleado, @PathVariable Long id) {
        InfoEmpleado infoEmpleadoActual = infoEmpleadoService.findById(id);
        infoEmpleadoActual.setPkCedula(infoEmpleado.getPkCedula());
        infoEmpleadoActual.setFechaDeNacimineto(infoEmpleado.getFechaDeNacimineto());
        infoEmpleadoActual.setDireccionDomicilio(infoEmpleado.getDireccionDomicilio());
        infoEmpleadoActual.setTelefonoMovil(infoEmpleado.getTelefonoMovil());
        infoEmpleadoActual.setEstadoVacunacion(infoEmpleado.getEstadoVacunacion());
        infoEmpleadoActual.setTipoVacuna(infoEmpleado.getTipoVacuna());
        infoEmpleadoActual.setFechaVacuna(infoEmpleado.getFechaVacuna());
        infoEmpleadoActual.setNumeroDosis(infoEmpleado.getNumeroDosis());

        return infoEmpleadoService.save(infoEmpleadoActual);
    }

    @Operation(summary = "Elimina informacion del empleado por medio de la cedula  ")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        infoEmpleadoService.delete(id);
    }
}
