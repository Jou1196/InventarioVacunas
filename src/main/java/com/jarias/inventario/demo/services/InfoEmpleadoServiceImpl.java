package com.jarias.inventario.demo.services;

import com.jarias.inventario.demo.entity.Empleados;
import com.jarias.inventario.demo.entity.InfoEmpleado;
import com.jarias.inventario.demo.models.dao.IInfoEmpleadoDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoEmpleadoServiceImpl implements IInfoEmpleadoService {

    @Autowired
    private IInfoEmpleadoDao infoEmpleadoDao;

    @Override
    public List<InfoEmpleado> findAll() {
        return (List<InfoEmpleado>) infoEmpleadoDao.findAll();
    }

    @Override
    public InfoEmpleado findById(Long id) {
        return infoEmpleadoDao.findById(id).orElse(null);
    }
    
   
   
      public List<InfoEmpleado> findEstadoVacuna(String estado) {
        return (List<InfoEmpleado>) infoEmpleadoDao.findEstadoVacuna(estado);
    }

    public List<InfoEmpleado> findTipoVacuna(String tipo) {
        return (List<InfoEmpleado>) infoEmpleadoDao.findTipoVacuna(tipo);
    }

    public List<InfoEmpleado> findFecha(String fecha, String fecha2) {
        return (List<InfoEmpleado>) infoEmpleadoDao.findFecha(fecha,fecha2);
    }
    
    

    @Override
    public InfoEmpleado save(InfoEmpleado infoEmpleado) {
        return infoEmpleadoDao.save(infoEmpleado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        infoEmpleadoDao.deleteById(id);
    }

}
