package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        return list.stream().filter(product -> id.equals(product.getId())).findAny().orElse(null);
    }

    public void addProduct(Product p) {
        if (!list.isEmpty()) {
            Product lastProduct = list.get(list.size() - 1);
            p.setId(lastProduct.getId() + 1);
        } else {
            p.setId(1L);
        }
        p.setCreatedOne(LocalDateTime.now());
        p.setStatus(true);
        list.add(p);
    }

    public void updateProduct(Product p) {
        list.stream().filter(product -> p.getId().equals(product.getId())).findFirst().ifPresent(productFound -> this.list.set(list.indexOf(productFound), p));
    }

    public void removeProduct(Product p) {
        list.remove(p);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }

}
