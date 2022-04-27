/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jarias.inventario.demo.models.dao;

import com.jarias.inventario.demo.entity.Empleados;
import com.jarias.inventario.demo.entity.InfoEmpleado;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface IInfoEmpleadoDao extends CrudRepository<InfoEmpleado, Long> {
    
      @Query(nativeQuery = true, value = "Select * from info_empleado i where i.estado_vacunacion= :estado")
      public List<InfoEmpleado> findEstadoVacuna(@Param("estado") String estado);
      
      @Query(nativeQuery = true, value = "Select * from info_empleado i where i.tipo_vacuna= :tipo")
      public List<InfoEmpleado> findTipoVacuna(@Param("tipo") String tipo);
      //value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate"
       
      @Query( nativeQuery = true,value = "Select * from info_empleado i where i.fecha_vacuna BETWEEN cast(:fecha AS timestamp) AND cast(:fecha2 AS timestamp) ")
      
      public List<InfoEmpleado> findFecha(@Param("fecha") String fecha , @Param("fecha2") String fecha2);
      
         
}
