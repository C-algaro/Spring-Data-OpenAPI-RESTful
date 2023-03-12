package com.apirest.springboot.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// Model = Objeto abstrato que será representado no recurso da API, por isso deve ser um substantivo segundo padrões REST.
//@Entity para que seja uma entidade no banco de dados e @Table para definir o nome da tabela.
@Entity
@Table(name = "TB_PRODUTS")
public class ProductModel implements Serializable {
    // Define que essa é a primeira versão da classe. 
    // Se fizer alguma alteração estrutural incompatível com versões anteriores, você mudará o serialVersionUID para 2L 
    private static final long serialVersionUID = 1L;

    @Id //IDs do tipo UUIDs são identificadores temporais universalmente exclusivos indicado principalmente em arquiteturas distribuidas.
    @GeneratedValue(strategy=GenerationType.AUTO) //id gerado de forma automática em cada persistência de Product no banco de dados.
    private UUID idProduct;
    @NotEmpty(message = "{name.notEmpty}")
    @Size(min = 2, max = 100, message = "{name.size}")
    @Column(name="name", nullable=false)
    private String name;
    @Min(value = 0, message = "{value.min}")
    @Column(name="value", nullable=false)
    private Double value;

    
    public ProductModel() {
    }
    public ProductModel(String name, Double value) {
        this.name=name;
        this.value=value;
    }


    public UUID getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ProductModel [idProduct=" + idProduct + ", name=" + name + ", value=" + value + "]";
    }

}