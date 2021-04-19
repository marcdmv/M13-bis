package com.example.demo.bean;

import java.util.ArrayList;

public class BaseDatos {

    ArrayList<Libro> libros = new ArrayList<>();

    public BaseDatos() {
        libros.add(new Libro(1,"Harry potter","JKRowling","Salamandra","26/9/2006", "Infantil"));
        libros.add(new Libro(2,"El gran laberinto","Fernando","Ariel","26/9/2006", "Ficcion"));
        libros.add(new Libro(3,"Romeo y Julieta","W Shakespeare","Salamandra","26/9/2006", "Romantica"));
    }
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public void setLibros(ArrayList<Libro> libros){
        this.libros = libros;
    }
}
