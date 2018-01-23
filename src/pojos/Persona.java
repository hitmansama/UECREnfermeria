package pojos;
// Generated 19/01/2018 10:51:38 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer id;
     private String nombres;
     private String apellidos;
     private String genero;
     private Date fechaNacimiento;
     private Byte srp01;
     private Byte hpv01;
     private Byte srp02;
     private Byte hpv02;
     private Byte influencia;
     private Set alumnos = new HashSet(0);

    public Persona() {
    }

	
    public Persona(String nombres, String apellidos, String genero, Date fechaNacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Persona(String nombres, String apellidos, String genero, Date fechaNacimiento, Byte srp01, Byte hpv01, Byte srp02, Byte hpv02, Byte influencia, Set alumnos) {
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.genero = genero;
       this.fechaNacimiento = fechaNacimiento;
       this.srp01 = srp01;
       this.hpv01 = hpv01;
       this.srp02 = srp02;
       this.hpv02 = hpv02;
       this.influencia = influencia;
       this.alumnos = alumnos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Byte getSrp01() {
        return this.srp01;
    }
    
    public void setSrp01(Byte srp01) {
        this.srp01 = srp01;
    }
    public Byte getHpv01() {
        return this.hpv01;
    }
    
    public void setHpv01(Byte hpv01) {
        this.hpv01 = hpv01;
    }
    public Byte getSrp02() {
        return this.srp02;
    }
    
    public void setSrp02(Byte srp02) {
        this.srp02 = srp02;
    }
    public Byte getHpv02() {
        return this.hpv02;
    }
    
    public void setHpv02(Byte hpv02) {
        this.hpv02 = hpv02;
    }
    public Byte getInfluencia() {
        return this.influencia;
    }
    
    public void setInfluencia(Byte influencia) {
        this.influencia = influencia;
    }
    public Set getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set alumnos) {
        this.alumnos = alumnos;
    }
    @Override
    public String toString(){
        return this.nombres+" "+this.apellidos;
    }
    


}

