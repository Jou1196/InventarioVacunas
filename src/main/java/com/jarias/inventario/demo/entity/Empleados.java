/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jarias.inventario.demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByPkCedula", query = "SELECT e FROM Empleados e WHERE e.pkCedula = :pkCedula"),
    @NamedQuery(name = "Empleados.findByNombres", query = "SELECT e FROM Empleados e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleados.findByCorreoElectronico", query = "SELECT e FROM Empleados e WHERE e.correoElectronico = :correoElectronico")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_cedula")
    private Long pkCedula;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleados")
    private InfoEmpleado infoEmpleado;

    public Empleados() {
    }

    public Empleados(Long pkCedula) {
        this.pkCedula = pkCedula;
    }

    public Empleados(Long pkCedula, String nombres, String apellidos, String correoElectronico) {
        this.pkCedula = pkCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }

    public Long getPkCedula() {
        return pkCedula;
    }

    public void setPkCedula(Long pkCedula) {
        this.pkCedula = pkCedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public InfoEmpleado getInfoEmpleado() {
        return infoEmpleado;
    }

    public void setInfoEmpleado(InfoEmpleado infoEmpleado) {
        this.infoEmpleado = infoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCedula != null ? pkCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.pkCedula == null && other.pkCedula != null) || (this.pkCedula != null && !this.pkCedula.equals(other.pkCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jarias.inventario.demo.entity.Empleados[ pkCedula=" + pkCedula + " ]";
    }
    
}
