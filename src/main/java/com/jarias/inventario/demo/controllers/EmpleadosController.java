/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jarias.inventario.demo.controllers;

import com.jarias.inventario.demo.entity.Empleados;
import com.jarias.inventario.demo.services.IEmpleadosService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    IEmpleadosService empleadosService;

    @Operation(summary = "Lista todos los objetos de empleado")
    @GetMapping("/")
    public List<Empleados> index() {
        return empleadosService.findAll();
    }

    @Operation(summary = "Lista todos los objetos de empleado por nombre")
    @CrossOrigin
    @GetMapping("/list")
    public List<Empleados> list(@RequestParam("nombres") String nombres) {
        return empleadosService.findNombres(nombres);

    }

    @Operation(summary = "Lista todos los objetos de empleado por cedula o id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Empleados show(@PathVariable Long id) {
        return empleadosService.findById(id);
    }

    @Operation(summary = "Guarda Un objeto Empleado")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleados create(@RequestBody Empleados empleados) {
        return empleadosService.save(empleados);
    }

    @Operation(summary = "Actualiza Un objeto Empleado")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleados update(@RequestBody Empleados empleados, @PathVariable Long id) {
        Empleados EmpleadosActual = empleadosService.findById(id);
        EmpleadosActual.setPkCedula(empleados.getPkCedula());
        EmpleadosActual.setNombres(empleados.getNombres());
        EmpleadosActual.setApellidos(empleados.getApellidos());
        EmpleadosActual.setCorreoElectronico(empleados.getCorreoElectronico());

        return empleadosService.save(EmpleadosActual);
    }

    @Operation(summary = "Elimina los objetos de empleado por id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        empleadosService.delete(id);
    }
}
