/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.examen_ariel_aguirre.service;

import com.examen.examen_ariel_aguirre.model.Producto;
import com.examen.examen_ariel_aguirre.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService {

    @Autowired
    ProductoRepository productoaRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoaRepository;
    }

}
