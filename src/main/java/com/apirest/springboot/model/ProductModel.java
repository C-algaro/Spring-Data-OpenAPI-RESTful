package com.apirest.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Model = Objeto abstrato que será representado no recurso da API, por isso deve ser um substantivo segundo padrões REST.
//@Entity para que seja uma entidade no banco de dados e @Table para definir o nome da tabela.
@Entity
@Table(name = "TB_PRODUTS")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //IDs do tipo UUIDs são identificadores temporais universalmente exclusivos indicado principalmente em arquiteturas distribuidas.
    @GeneratedValue(strategy=GenerationType.AUTO) //id gerado de forma automática em cada persistência de Product no banco de dados.
    private UUID idProduct;
    private String name;
    private BigDecimal value;

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    
}