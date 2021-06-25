package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DatosMascota implements Serializable {
    //Atributos
    @Id
    private int numCliente;
    @Basic
    private String nombrePerro;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEspecial;
    private String nombreDuenio;
    private String celularDuenio;
    private String observaciones;

    //Constructor vacio
    public DatosMascota() {
    }

    //Constructor completo
    public DatosMascota(int numCliente, String nombrePerro, String raza, 
            String color, String alergico, String atencionEspecial, String nombreDuenio, 
            String celularDuenio, String observaciones) {
        this.numCliente = numCliente;
        this.nombrePerro = nombrePerro;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEspecial = atencionEspecial;
        this.nombreDuenio = nombreDuenio;
        this.celularDuenio = celularDuenio;
        this.observaciones = observaciones;
    }

    //Getters and Setters
    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombrePerro() {
        return nombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String isAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String isAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(String atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public String getCelularDuenio() {
        return celularDuenio;
    }

    public void setCelularDuenio(String celularDuenio) {
        this.celularDuenio = celularDuenio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
