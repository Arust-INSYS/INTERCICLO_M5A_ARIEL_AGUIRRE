/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.examen_ariel_aguirre.controller;

import com.examen.examen_ariel_aguirre.model.Producto;
import com.examen.examen_ariel_aguirre.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/producto")
public class ProductoController {
     @Autowired
    ProductoService productoService;

    /*
   @GetMapping("/listar")
   public List<Cancion>listarCancion(){
       try {
           return cancionService.findAll();
       }catch (Exception e){

       }
       return cancionService.findAll();
   }*/

    @GetMapping("/buscar/{id}")
    public Producto buscar_Producto(@PathVariable Integer id){
        return productoService.findById(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar_Producto() {
        try {
            return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    /*
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cancion guardarCancion(@RequestBody Cancion cancion){
        return cancionService.save(cancion);
    }
*/
    @PostMapping("/guardar")
    public ResponseEntity<Producto> SaveProduct(@RequestBody Producto p){
        try {
            return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    /*
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable Integer id){
        cancionService.delete(id);
    }
*/
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Integer id) {
        try {
            productoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo eliminar registro");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Producto> updateClient(@RequestBody Producto prod, @PathVariable("id") Integer id){
        Producto update = productoService.findById(id);

        if(update == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                Producto producto=productoService.findById(id);
                producto.setDescripcion(prod.getDescripcion());
                producto.setPrecio(prod.getPrecio());
                producto.setCantidad(prod.getCantidad());
                                         
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
    
    
}
