package com.example.demo.controllers;

import com.example.demo.service.BaseDatos;
import com.example.demo.bean.Libro;
import com.example.demo.bean.Usuario;
import com.example.demo.service.BaseDatos2;
import com.example.demo.service.BaseDatos3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping("")
public class Controlador {

    //BaseDatos bd = new BaseDatos();
    Usuario usuario;

    BaseDatos2 bd2 = new BaseDatos2();
    @Autowired
    BaseDatos3 bd;

    @GetMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("titulo", "FORMULARIO DE ACCESO");
        return "login";
    }

    @PostMapping("/")
    public String login(Usuario usuario, Model model) {
        if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
            //ArrayList<Libro> libros = bd.getLibros();
            ArrayList<Libro> libros = (ArrayList<Libro>) bd.findAll();

            model.addAttribute("usuario",usuario);
            this.usuario = usuario;
            model.addAttribute("libros",libros);
            model.addAttribute("boton","Inserta Libro");
            model.addAttribute("action", "/insertar");
            return "consulta";
        }
        else
            model.addAttribute("titulo","FORMULARIO DE ACCESO");
            return "login";
    }

    @PostMapping("/insertar")
    public String insertar(Libro libro, Model model) {
        //bd.inserta(libro);
        bd.save(libro);

        //ArrayList<Libro> libros = bd.getLibros();
        ArrayList<Libro> libros = (ArrayList<Libro>) bd.findAll();

        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton","Inserta Libro");
        model.addAttribute("action", "/insertar");
        model.addAttribute("libro", null);
        return "consulta";
    }

    @GetMapping("/borrado/{id}")
    public String borrar(@PathVariable int id, Model model) {
        //bd.borrar(id);
        bd.deleteById(id);
        //ArrayList<Libro> libros = bd.getLibros();
        ArrayList<Libro> libros = (ArrayList<Libro>) bd.findAll();
        model.addAttribute("libros", libros);
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("boton", "Borra Libro");
        model.addAttribute("action","/insertar");
        return "consulta";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {
        //Libro libro = bd.getLibro(id);
        Libro libro = bd.findById(id).get();

        //ArrayList<Libro> libros = bd.getLibros();
        ArrayList<Libro> libros = (ArrayList<Libro>) bd.findAll();
        model.addAttribute("libros",libros);
        model.addAttribute("libro",libro);
        model.addAttribute("usuario",this.usuario);
        model.addAttribute("boton","Actualiza Libro");
        model.addAttribute("action","/modificar");
        return "consulta";
    }

    @PostMapping("/modificar")
    public String modificar2(Libro libro, Model model) {
        //bd.modifica(libro);
        bd.save(libro);

        //ArrayList<Libro> libros = bd.getLibros();
        ArrayList<Libro> libros = (ArrayList<Libro>) bd.findAll();

        model.addAttribute("usuario",this.usuario);
        model.addAttribute("libros",libros);
        model.addAttribute("libro",null);
        model.addAttribute("boton","Inserta Libro");
        model.addAttribute("action","/insertar");
        return "consulta";
    }
}
