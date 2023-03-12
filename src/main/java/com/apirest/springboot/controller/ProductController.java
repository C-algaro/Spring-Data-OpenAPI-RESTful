package com.apirest.springboot.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.springboot.model.ProductModel;
import com.apirest.springboot.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Operation(summary = "Retorna lista de produtos")
    @GetMapping()
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return new ResponseEntity<List<ProductModel>>(productRepository.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna produto pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ProductModel>(product0.get(), HttpStatus.OK);
    }

    @Operation(summary = "Exclui um produto pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        productRepository.delete(product0.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Cria um novo produto")
    @PostMapping()
    public ResponseEntity<ProductModel> saveProduct(@org.springframework.web.bind.annotation.RequestBody @Valid ProductModel product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza campos de um produto pela id")
    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable(value="id") UUID id, @org.springframework.web.bind.annotation.RequestBody @Valid ProductModel product) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ProductModel producto = product0.get();
        producto.setName(product.getName());
        producto.setValue(product.getValue());
        return new ResponseEntity<>(productRepository.save(producto), HttpStatus.OK);
    }
}