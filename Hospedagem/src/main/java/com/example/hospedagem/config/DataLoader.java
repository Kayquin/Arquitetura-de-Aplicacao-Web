package com.example.hospedagem.config;

import com.example.hospedagem.model.Categoria;
import com.example.hospedagem.model.Documento;
import com.example.hospedagem.repository.CategoriaRepository;
import com.example.hospedagem.repository.DocumentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(CategoriaRepository categoriaRepository, DocumentoRepository documentoRepository) {
        return args -> {
            if (categoriaRepository.count() == 0) {
                Categoria cat1 = new Categoria();
                cat1.setNome("Manual");
                cat1.setDescricao("Documentos manuais");
                categoriaRepository.save(cat1);

                Documento d1 = new Documento();
                d1.setTitulo("Primeiro documento");
                d1.setConteudo("Conteúdo de exemplo");
                d1.setCategoria(cat1);
                documentoRepository.save(d1);
            }
        };
    }
}
