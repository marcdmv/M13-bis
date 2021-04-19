package com.example.demo.service;

import com.example.demo.bean.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDatos3 extends JpaRepository<Libro, Integer> {
}
