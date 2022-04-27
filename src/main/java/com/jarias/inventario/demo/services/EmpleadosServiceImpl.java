/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jarias.inventario.demo.services;

import com.jarias.inventario.demo.entity.Empleados;
import com.jarias.inventario.demo.models.dao.IEmpleadosDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class EmpleadosServiceImpl implements IEmpleadosService {

    @Autowired
    private IEmpleadosDao empleadosDao;

    @Override
    public List<Empleados> findAll() {
        return (List<Empleados>) empleadosDao.findAll();
    }

    @Override
    public Empleados findById(Long id) {
        return empleadosDao.findById(id).orElse(null);
    }

    public List<Empleados> findNombres(String nombres) {
        return (List<Empleados>) empleadosDao.findNombres(nombres);
    }

  

    @Override
    public Empleados save(Empleados empleado) {
        return empleadosDao.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empleadosDao.deleteById(id);
    }
}
