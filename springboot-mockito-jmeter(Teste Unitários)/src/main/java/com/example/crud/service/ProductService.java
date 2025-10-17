package com.example.crud.service;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public Product create(Product product) { return repository.save(product); }
    public List<Product> findAll() { return repository.findAll(); }
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }
    public Product update(Long id, Product updated) {
        Product existing = findById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        return repository.save(existing);
    }
    public void delete(Long id) {
        Product existing = findById(id);
        repository.delete(existing);
    }
}