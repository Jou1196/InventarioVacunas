/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jarias.inventario.demo.services;

import com.jarias.inventario.demo.entity.Empleados;
import com.jarias.inventario.demo.entity.InfoEmpleado;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface IInfoEmpleadoService {
     public List<InfoEmpleado> findAll();
    
    public InfoEmpleado findById(Long id);
    
     public List<InfoEmpleado> findEstadoVacuna(String estado);

    public List<InfoEmpleado> findTipoVacuna(String tipo);

    public List<InfoEmpleado> findFecha( String fecha, String fecha2);
    
    public InfoEmpleado save(InfoEmpleado infoEmpleado);
    
     public void delete(Long id);
}
