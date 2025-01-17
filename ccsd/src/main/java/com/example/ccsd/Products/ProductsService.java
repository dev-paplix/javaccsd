package com.example.ccsd.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private com.example.ccsd.Products.ProductsRepository productsRepository;

    // Fetch all products
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    // Add a new product
    public Products addProducts(Products product) {
        return productsRepository.save(product);
    }

    // Get a product by ID
    public ResponseEntity<Products> getProductsById(String id) {
        Optional<Products> product = productsRepository.findById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update an existing product
    public Products updateProducts(String id, Products productsDetail) {
        Optional<Products> existingProduct = productsRepository.findById(id);
        if (existingProduct.isPresent()) {
            Products product = existingProduct.get();
            product.setTitle(productsDetail.getTitle());
            product.setPostSlug(productsDetail.getPostSlug());
            product.setPostShortDescription(productsDetail.getPostShortDescription());
            product.setTag(productsDetail.getTag());
            product.setPlace(productsDetail.getPlace());
            product.setDateProduct(productsDetail.getDateProduct());
            product.setStatus(productsDetail.getStatus());
            product.setImageStore(productsDetail.getImageStore());
            return productsRepository.save(product);
        }
        return null; // Return null if product not found
    }

    // Delete a product by ID
    public void deleteProducts(String id) {
        productsRepository.deleteById(id);
    }
}
