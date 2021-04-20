package com.example.demo.service;

import com.example.demo.bean.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDatos3 extends JpaRepository<Empleado, Integer> {
}
