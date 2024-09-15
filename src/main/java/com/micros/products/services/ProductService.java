package com.micros.products.services;

import com.micros.products.entities.Product;
import com.micros.products.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Value("${server.port}")
    private String serverPort;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ((List<Product>) productRepository.findAll()).stream()
                .peek(p -> p.setPort(Integer.parseInt(serverPort)))
                .toList();
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(p -> {
            p.setPort(Integer.parseInt(serverPort));
            return p;
        });
   }




}
