package com.example.demo.controllers;

import com.example.demo.bean.Empleado;
import com.example.demo.bean.Usuario;
import com.example.demo.service.BaseDatos2;
import com.example.demo.service.BaseDatos3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            //ArrayList<Empleado> empleados = bd.getEmpleados();
            ArrayList<Empleado> empleados = (ArrayList<Empleado>) bd.findAll();

            model.addAttribute("usuario",usuario);
            this.usuario = usuario;
            model.addAttribute("empleados",empleados);
            model.addAttribute("boton","Inserta Empleado");
            model.addAttribute("action", "/insertar");
            return "consulta";
        }
        else
            model.addAttribute("titulo","FORMULARIO DE ACCESO");
            return "login";
    }

    @PostMapping("/insertar")
    public String insertar(Empleado empleado, Model model) {
        //bd.inserta(empleado);
        bd.save(empleado);

        //ArrayList<Empleado> empleados = bd.getEmpleados();
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) bd.findAll();

        model.addAttribute("usuario", this.usuario);
        model.addAttribute("empleados", empleados);
        model.addAttribute("boton","Inserta Empleado");
        model.addAttribute("action", "/insertar");
        model.addAttribute("empleado", null);
        return "consulta";
    }

    @GetMapping("/borrado/{id}")
    public String borrar(@PathVariable int id, Model model) {
        //bd.borrar(id);
        bd.deleteById(id);
        //ArrayList<Empleado> empleados = bd.getEmpleados();
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) bd.findAll();
        model.addAttribute("empleados", empleados);
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("boton", "Borra Empleado");
        model.addAttribute("action","/insertar");
        return "consulta";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {
        //Empleado empleado = bd.getEmpleado(id);
        Empleado empleado = bd.findById(id).get();

        //ArrayList<Empleados> empleados = bd.getEmpleados();
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) bd.findAll();
        model.addAttribute("empleados",empleados);
        model.addAttribute("empleado",empleado);
        model.addAttribute("usuario",this.usuario);
        model.addAttribute("boton","Actualiza Empleado");
        model.addAttribute("action","/modificar");
        return "consulta";
    }

    @PostMapping("/modificar")
    public String modificar2(Empleado empleado, Model model) {
        //bd.modifica(empleado);
        bd.save(empleado);

        //ArrayList<Empleado> empleados = bd.getEmpleados();
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) bd.findAll();

        model.addAttribute("usuario",this.usuario);
        model.addAttribute("empleados",empleados);
        model.addAttribute("empleado",null);
        model.addAttribute("boton","Inserta Empleado");
        model.addAttribute("action","/insertar");
        return "consulta";
    }
}
