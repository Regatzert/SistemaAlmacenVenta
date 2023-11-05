package com.KevinSR.product.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KevinSR.product.crud.Exception.ResourceNotFoundException;
import com.KevinSR.product.crud.entity.Product;
import com.KevinSR.product.crud.repository.ProductRepository;

@RestController
@RequestMapping("/api/producto")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable (value = "id") Integer IdProducto){
        return this.productRepository.findById(IdProducto)
        .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el id: "+ IdProducto));
    }

    @PostMapping
    public Product createProduct (@RequestBody Product product){
        return this.productRepository.save(product);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct (@RequestBody Product product, @PathVariable (value = "id") Integer IdProducto){
        Product existing = this.productRepository.findById(IdProducto)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: "+ IdProducto));
        
        existing.setCodigo(product.getCodigo());
        existing.setNombre(product.getNombre());
        existing.setFVencimiento(product.getFVencimiento());
        existing.setPrecio(product.getPrecio());
        existing.setLaboratorio(product.getLaboratorio());
        existing.setLote(product.getLote());
        existing.setCantidad(product.getCantidad());
        existing.setActivo(product.getActivo());

        return this.productRepository.save(existing);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer IdProducto){
        Product existing = this.productRepository.findById(IdProducto)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: "+ IdProducto));
        
        this.productRepository.delete(existing);
        return ResponseEntity.ok().build();
    }
}
