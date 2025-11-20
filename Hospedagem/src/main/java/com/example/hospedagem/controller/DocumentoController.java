package com.example.hospedagem.controller;

import com.example.hospedagem.model.Documento;
import com.example.hospedagem.model.Categoria;
import com.example.hospedagem.repository.CategoriaRepository;
import com.example.hospedagem.repository.DocumentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private final DocumentoRepository documentoRepository;
    private final CategoriaRepository categoriaRepository;

    public DocumentoController(DocumentoRepository documentoRepository, CategoriaRepository categoriaRepository) {
        this.documentoRepository = documentoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Documento> list() {
        return documentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> get(@PathVariable Long id) {
        return documentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public static class DocumentoRequest {
        public String titulo;
        public String conteudo;
        public Long categoriaId;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DocumentoRequest req) {
        Documento doc = new Documento();
        doc.setTitulo(req.titulo);
        doc.setConteudo(req.conteudo);
        if (req.categoriaId != null) {
            Categoria cat = categoriaRepository.findById(req.categoriaId).orElse(null);
            doc.setCategoria(cat);
        }
        Documento saved = documentoRepository.save(doc);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documento> update(@PathVariable Long id, @Valid @RequestBody DocumentoRequest req) {
        return documentoRepository.findById(id).map(existing -> {
            existing.setTitulo(req.titulo);
            existing.setConteudo(req.conteudo);
            if (req.categoriaId != null) {
                Categoria cat = categoriaRepository.findById(req.categoriaId).orElse(null);
                existing.setCategoria(cat);
            } else {
                existing.setCategoria(null);
            }
            Documento saved = documentoRepository.save(existing);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return documentoRepository.findById(id).map(existing -> {
            documentoRepository.delete(existing);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
