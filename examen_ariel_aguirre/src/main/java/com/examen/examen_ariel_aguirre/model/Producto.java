/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.examen_ariel_aguirre.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter
@Setter
@Table(name ="producto")
public class Producto {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Float precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    
    
    
    
}
