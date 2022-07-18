package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/welcome")
    @ApiOperation("Responsável por retornar uma mensagem de boas vindas.")
    public ResponseEntity<String> messageWelcome() {
        return ResponseEntity.ok("BEM VINDO À PRODUCT REST API.");
    }

    @GetMapping("/allProducts")
    @ApiOperation("Responsável por retornar uma lista de produtos.")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    public ResponseEntity<List<Product>> findAll() {
        try {
            List<Product> products = productRepository.getAllProducts();
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation("Responsável por retornar um produto pelo id.")
    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Optional<Product> product = Optional.ofNullable(productRepository.getProductById(id));
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addProduct")
    @ApiOperation("Responsável por adicionar um produto.")
    @ApiResponse(code = 10, message = "Required fields not informed.")
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        try {
            productRepository.addProduct(product);
            return new ResponseEntity<>(productRepository.getProductById(product.getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProduct")
    @ApiOperation("Responsável por atualizar um produto.")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Optional<Product> productById = Optional.ofNullable(productRepository.getProductById(product.getId()));
        if (productById.isPresent()) {
            productRepository.updateProduct(product);
            return new ResponseEntity<>(productRepository.getProductById(product.getId()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation("Responsável por remover um produto.")
    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    public ResponseEntity<Void> delete(@RequestBody Product product) {
        try {
            Optional<Product> productById = Optional.ofNullable(productRepository.getProductById(product.getId()));
            if (productById.isPresent()) {
                productRepository.removeProduct(product);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
