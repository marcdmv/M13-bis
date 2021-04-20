package com.example.demo.service;

import com.example.demo.bean.Empleado;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatos {

    ArrayList<Empleado> empleados = new ArrayList<>();

    public BaseDatos() {
        empleados.add(new Empleado(1,"Maria","Garcia","Directora",85000));
        empleados.add(new Empleado(2,"Carlos","Fernandez","Comercial",45000));
        empleados.add(new Empleado(3,"Roberto","Smith","Soporte",30000));
    }

    public void inserta(Empleado empleado) {
        empleados.add(empleado);
    }

    public void borrar(int id) {
        Iterator<Empleado> it = empleados.iterator();
        while(it.hasNext()) {
            Empleado em = it.next();
            if (em.getId()==id) {
                it.remove();
                break;
            }
        }
    }

    public void modifica(Empleado empleado){
        Iterator<Empleado> it = empleados.iterator();
        while(it.hasNext()) {
            Empleado em = it.next();
            if (em.getId() == empleado.getId()) {
                em.setNombre(empleado.getNombre());
                em.setApellido(empleado.getApellido());
                em.setPuesto(empleado.getPuesto());
                em.setSalario(empleado.getSalario());
                break;
            }
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public Empleado getEmpleado(int id){
        return empleados.get(id);
    }

    public void setEmpleados(ArrayList<Empleado> empleados){
        this.empleados = empleados;
    }
}
