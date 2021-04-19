package com.example.demo.service;

import com.example.demo.bean.Libro;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatos {

    ArrayList<Libro> libros = new ArrayList<>();

    public BaseDatos() {
        libros.add(new Libro(1,"Harry potter","JKRowling","Salamandra","26/9/2006", "Infantil"));
        libros.add(new Libro(2,"El gran laberinto","Fernando","Ariel","26/9/2006", "Ficcion"));
        libros.add(new Libro(3,"Romeo y Julieta","W Shakespeare","Salamandra","26/9/2006", "Romantica"));
    }

    public void inserta(Libro libro) {
        libros.add(libro);
    }

    public void borrar(int id) {
        Iterator<Libro> it = libros.iterator();
        while(it.hasNext()) {
            Libro li = it.next();
            if (li.getId()==id) {
                it.remove();
                break;
            }
        }
    }

    public void modifica(Libro libro){
        Iterator<Libro> it =libros.iterator();
        while(it.hasNext()) {
            Libro li = it.next();
            if (li.getId() == libro.getId()) {
                li.setTitulo(libro.getTitulo());
                li.setAutor(libro.getAutor());
                li.setEditorial(libro.getEditorial());
                li.setFecha(libro.getFecha());
                li.setTematica(libro.getTematica());
                break;
            }
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public Libro getLibro(int id){
        return libros.get(id);
    }

    public void setLibros(ArrayList<Libro> libros){
        this.libros = libros;
    }
}
