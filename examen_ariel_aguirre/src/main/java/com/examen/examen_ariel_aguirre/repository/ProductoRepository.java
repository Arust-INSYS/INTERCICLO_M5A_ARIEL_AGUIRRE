/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.examen_ariel_aguirre.repository;

import com.examen.examen_ariel_aguirre.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usuario
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "Select * from producto a where p.codigo = :codigo", nativeQuery = true)
    public Producto buscarProducto(String codigo);
}
