package com.example.crud.controller;

import com.example.crud.model.Product;
import com.example.crud.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = service.create(product);
        return ResponseEntity.status(201).body(created);
    }
    @GetMapping
    public List<Product> listAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) { return service.update(id, product); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}