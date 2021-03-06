package pojos;
// Generated 07/02/2018 12:49:53 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Historialclinico generated by hbm2java
 */
public class Historialclinico  implements java.io.Serializable {


     private Integer id;
     private Alumno alumno;
     private String enfermedad;
     private Date fecha;
     private Date hora;
     private Byte seguimiento;
     private String recomendacion;
     private String detalle;

    public Historialclinico() {
    }

	
    public Historialclinico(Alumno alumno, String enfermedad, Date fecha, Date hora) {
        this.alumno = alumno;
        this.enfermedad = enfermedad;
        this.fecha = fecha;
        this.hora = hora;
    }
    public Historialclinico(Alumno alumno, String enfermedad, Date fecha, Date hora, Byte seguimiento, String recomendacion, String detalle) {
       this.alumno = alumno;
       this.enfermedad = enfermedad;
       this.fecha = fecha;
       this.hora = hora;
       this.seguimiento = seguimiento;
       this.recomendacion = recomendacion;
       this.detalle = detalle;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public String getEnfermedad() {
        return this.enfermedad;
    }
    
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public Byte getSeguimiento() {
        return this.seguimiento;
    }
    
    public void setSeguimiento(Byte seguimiento) {
        this.seguimiento = seguimiento;
    }
    public String getRecomendacion() {
        return this.recomendacion;
    }
    
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }




}


