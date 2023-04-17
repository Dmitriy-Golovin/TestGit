package com.product.products.models;

import com.product.products.enumm.Provider;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название товара не может быть пустым")
    @Size(min = 3, max = 30, message = "Название товара должно быть в дапазоне от 3 до 30 символов")
    @Column(length = 30, nullable = false, columnDefinition = "text")
    private String name;

    @DecimalMin("1.0")
    @Column(nullable = false, columnDefinition = "float", precision = 10, scale = 2)
    private float price;

    @NotEmpty(message = "Вес товара не может быть пустым")
    @Pattern(regexp = "^(([1-9]{1}[0-9]{1,2}|[1-9]{1}[0-9]{1,2},[0-9]{1,2}))$", message = "Вес товара должен быть в дапазоне от 1 до 1000 кг")
    @Column(length = 6, nullable = false, columnDefinition = "text")
    private String weight;

    @NotNull(message = "Поле 'поставщик' не может быть пустым")
    @Column(length = 30, nullable = false, columnDefinition = "text")
    private Provider provider;

    public Product(int id, String name, float price, String weight, Provider provider) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.provider = provider;
    }

    public Product() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", weight='" + getWeight() + "'" +
            ", provider='" + getProvider() + "'" +
            "}";
    }

}
