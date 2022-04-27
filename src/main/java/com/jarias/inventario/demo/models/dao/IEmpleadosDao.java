/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jarias.inventario.demo.models.dao;

import com.jarias.inventario.demo.entity.Empleados;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface IEmpleadosDao extends CrudRepository<Empleados, Long>{
      @Query(nativeQuery = true, value = "Select * from empleados e where e.nombres= :nombres")
      public List<Empleados> findNombres(@Param("nombres") String nombres);
      
    
      
}
