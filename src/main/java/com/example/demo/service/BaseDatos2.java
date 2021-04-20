package com.example.demo.service;

import com.example.demo.bean.Empleado;

import java.sql.*;
import java.util.ArrayList;

public class BaseDatos2 {

    private Connection conexion;

    public BaseDatos2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conex="jdbc:mysql://localhost:3306/empleados_online";
            this.conexion = DriverManager.getConnection(conex,"root","Enjoy");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserta(Empleado empleado) {
        String query = " insert into empleados (id, nombre, apellido, puesto, salario)"
                + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStmt;
            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt (1, empleado.getId());
            preparedStmt.setString(2, empleado.getNombre());
            preparedStmt.setString(3,empleado.getApellido());
            preparedStmt.setString(4,empleado.getPuesto());
            preparedStmt.setInt(5,empleado.getSalario());
            preparedStmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void borrar(int id) {
        String query = " delete from empleados where id="+id;

        try {
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void modifica(Empleado empleado) {
        String query = " UPDATE empleados SET nombre=?, apellido=?, puesto=?, salario=?" + " WHERE id=?";
        try {
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1,empleado.getNombre());
            preparedStmt.setString(2,empleado.getApellido());
            preparedStmt.setString(3,empleado.getPuesto());
            preparedStmt.setInt(4,empleado.getSalario());
            preparedStmt.setInt(5, empleado.getId());
            System.out.print(preparedStmt.toString());

            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public Empleado getEmpleado(int id) {
        Empleado empleado = null;
        try {
            Statement s = conexion.createStatement();
            String sql = "SELECT * FROM empleados WHERE id="+id;
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            rs.next();
            empleado = new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return empleado;
    }

    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            Statement s = conexion.createStatement();
            String sql = "SELECT * FROM empleados";
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                Empleado empleado = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5));
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return empleados;
    }
}
