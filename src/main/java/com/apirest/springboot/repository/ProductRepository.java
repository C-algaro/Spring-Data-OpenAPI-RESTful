package com.apirest.springboot.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.springboot.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{
    
}
