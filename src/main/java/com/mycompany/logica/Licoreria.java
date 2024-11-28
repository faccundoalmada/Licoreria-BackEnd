
package com.mycompany.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Licoreria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    private String tipo;
    private String marca;
    private int cantidad;
    private int gondola;
    
    
    
    public Licoreria(){}; 

    
    public Licoreria(int id, String tipo, String marca, int cantidad, int gondola) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.cantidad = cantidad;
        this.gondola = gondola;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getGondola() {
        return gondola;
    }

    public void setGondola(int gondola) {
        this.gondola = gondola;
    }
    
    
    
    
    
    
    
}
