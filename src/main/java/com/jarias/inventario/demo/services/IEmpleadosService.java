/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jarias.inventario.demo.services;

import com.jarias.inventario.demo.entity.Empleados;
import java.util.List;

/**
 *
 * @author User
 */
public interface IEmpleadosService {

    public List<Empleados> findAll();

    public List<Empleados> findNombres(String nombres);

   

    public Empleados findById(Long id);

    public Empleados save(Empleados empleados);

    public void delete(Long id);
}
