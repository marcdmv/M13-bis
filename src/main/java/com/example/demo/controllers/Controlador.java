package com.example.demo.controllers;

import com.example.demo.bean.BaseDatos;
import com.example.demo.bean.Libro;
import com.example.demo.bean.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("")
public class Controlador {

    BaseDatos bd = new BaseDatos();

    @GetMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("titulo", "FORMULARIO DE ACCESO");
        return "login";
    }

    @PostMapping("/")
    public String login(Usuario usuario, Model model) {
        if (usuario.getNombre().equals("a") && usuario.getPassword().equals("a")) {
            ArrayList<Libro> libros = bd.getLibros();
            model.addAttribute("usuario",usuario);
            model.addAttribute("libros",libros);
            return "consulta";
        }
        else
            return "login";
    }
}
