/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jarias.inventario.demo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "info_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoEmpleado.findAll", query = "SELECT i FROM InfoEmpleado i"),
    @NamedQuery(name = "InfoEmpleado.findByPkCedula", query = "SELECT i FROM InfoEmpleado i WHERE i.pkCedula = :pkCedula"),
    @NamedQuery(name = "InfoEmpleado.findByFechaDeNacimineto", query = "SELECT i FROM InfoEmpleado i WHERE i.fechaDeNacimineto = :fechaDeNacimineto"),
    @NamedQuery(name = "InfoEmpleado.findByDireccionDomicilio", query = "SELECT i FROM InfoEmpleado i WHERE i.direccionDomicilio = :direccionDomicilio"),
    @NamedQuery(name = "InfoEmpleado.findByTelefonoMovil", query = "SELECT i FROM InfoEmpleado i WHERE i.telefonoMovil = :telefonoMovil"),
    @NamedQuery(name = "InfoEmpleado.findByEstadoVacunacion", query = "SELECT i FROM InfoEmpleado i WHERE i.estadoVacunacion = :estadoVacunacion"),
    @NamedQuery(name = "InfoEmpleado.findByTipoVacuna", query = "SELECT i FROM InfoEmpleado i WHERE i.tipoVacuna = :tipoVacuna"),
    @NamedQuery(name = "InfoEmpleado.findByFechaVacuna", query = "SELECT i FROM InfoEmpleado i WHERE i.fechaVacuna = :fechaVacuna"),
    @NamedQuery(name = "InfoEmpleado.findByNumeroDosis", query = "SELECT i FROM InfoEmpleado i WHERE i.numeroDosis = :numeroDosis")})
public class InfoEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_cedula")
    private Long pkCedula;
    @Basic(optional = false)
    @Column(name = "fecha_de_nacimineto")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimineto;
    @Basic(optional = false)
    @Column(name = "direccion_domicilio")
    private String direccionDomicilio;
    @Basic(optional = false)
    @Column(name = "telefono_movil")
    private long telefonoMovil;
    @Basic(optional = false)
    @Column(name = "estado_vacunacion")
    private String estadoVacunacion;
    @Column(name = "tipo_vacuna")
    private String tipoVacuna;
    @Column(name = "fecha_vacuna")
    @Temporal(TemporalType.DATE)
    private Date fechaVacuna;
    @Column(name = "numero_dosis")
    private String numeroDosis;
    @JoinColumn(name = "pk_cedula", referencedColumnName = "pk_cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleados empleados;

    public InfoEmpleado() {
    }

    public InfoEmpleado(Long pkCedula) {
        this.pkCedula = pkCedula;
    }

    public InfoEmpleado(Long pkCedula, Date fechaDeNacimineto, String direccionDomicilio, long telefonoMovil, String estadoVacunacion) {
        this.pkCedula = pkCedula;
        this.fechaDeNacimineto = fechaDeNacimineto;
        this.direccionDomicilio = direccionDomicilio;
        this.telefonoMovil = telefonoMovil;
        this.estadoVacunacion = estadoVacunacion;
    }

    public Long getPkCedula() {
        return pkCedula;
    }

    public void setPkCedula(Long pkCedula) {
        this.pkCedula = pkCedula;
    }

    public Date getFechaDeNacimineto() {
        return fechaDeNacimineto;
    }

    public void setFechaDeNacimineto(Date fechaDeNacimineto) {
        this.fechaDeNacimineto = fechaDeNacimineto;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public long getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(long telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(String estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(String numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
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
        if (!(object instanceof InfoEmpleado)) {
            return false;
        }
        InfoEmpleado other = (InfoEmpleado) object;
        if ((this.pkCedula == null && other.pkCedula != null) || (this.pkCedula != null && !this.pkCedula.equals(other.pkCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jarias.inventario.demo.entity.InfoEmpleado[ pkCedula=" + pkCedula + " ]";
    }
    
}
