package com.example.demo.bean;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private String fecha;
    private String tematica;

    public Libro(int id, String titulo, String autor, String editorial, String fecha, String tematica) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha = fecha;
        this.tematica = tematica;
    }
}
