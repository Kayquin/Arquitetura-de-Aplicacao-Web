package com.example.crud.service;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @Mock private ProductRepository repository;
    @InjectMocks private ProductService service;
    @BeforeEach void setup() { MockitoAnnotations.openMocks(this); }

    @Test void createProduct_shouldReturnSaved() {
        Product p = new Product(null, "P1", "Desc", 10.0, 5);
        Product saved = new Product(1L, "P1", "Desc", 10.0, 5);
        when(repository.save(p)).thenReturn(saved);
        Product result = service.create(p);
        assertEquals(1L, result.getId());
        verify(repository, times(1)).save(p);
    }
    @Test void findAll_shouldReturnList() {
        when(repository.findAll()).thenReturn(List.of(new Product(1L, "P1", "D", 1.0, 1)));
        List<Product> list = service.findAll();
        assertFalse(list.isEmpty());
        verify(repository).findAll();
    }
    @Test void findById_whenFound() {
        when(repository.findById(1L)).thenReturn(Optional.of(new Product(1L, "P", "D", 1.0, 1)));
        Product p = service.findById(1L);
        assertEquals(1L, p.getId());
    }
    @Test void findById_whenNotFound_shouldThrow() {
        when(repository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.findById(2L));
    }
    @Test void update_shouldModifyAndSave() {
        Product existing = new Product(1L, "Old", "D", 1.0, 1);
        Product updated = new Product(null, "New", "D2", 2.0, 2);
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));
        Product result = service.update(1L, updated);
        assertEquals("New", result.getName());
        verify(repository).save(existing);
    }
    @Test void delete_shouldCallRepositoryDelete() {
        Product existing = new Product(1L, "P", "D", 1.0, 1);
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        service.delete(1L);
        verify(repository).delete(existing);
    }
}