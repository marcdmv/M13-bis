package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre", nullable = false,length = 30)
    private String nombre;
    private String apellido;
    private String puesto;
    private int salario;

    public Empleado(int id, String nombre, String apellido, String puesto, int salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.salario = salario;
    }

    public Empleado () {

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario){
        this.salario = salario;
    }
}
