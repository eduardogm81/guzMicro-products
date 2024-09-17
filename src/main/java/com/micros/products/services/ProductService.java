package com.micros.products.services;

import com.micros.products.entities.Product;
import com.micros.products.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ServerPortService serverPortService;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        int serverPort = serverPortService.getServerPort();
        return ((List<Product>) productRepository.findAll()).stream()
                .peek(p -> p.setPort(serverPort))
                .toList();
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        int serverPort = serverPortService.getServerPort();
        return productRepository.findById(id).map(p -> {
            p.setPort(serverPort);
            return p;
        });
   }

}
