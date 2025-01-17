package com.example.ccsd.Products;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable String id) {
        return productsService.getProductsById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addProduct(
            @RequestParam("title") String title,
            @RequestParam("postSlug") String postSlug,
            @RequestParam("postShortDescription") String postShortDescription,
            @RequestParam("tag") String tag,
            @RequestParam("place") String place,
            @RequestParam("date") String date,
            @RequestParam("status") String status,
            @RequestParam("image") MultipartFile image) throws IOException {

        byte[] imageBytes = image.getBytes();
        Products product = new Products();
        product.setTitle(title);
        product.setPostSlug(postSlug);
        product.setPostShortDescription(postShortDescription);
        product.setTag(tag);
        product.setPlace(place);
        product.setDateProduct(date);
        product.setStatus(status);
        product.setImageStore(imageBytes);

        Products savedProduct = productsService.addProducts(product);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("product", savedProduct);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable String id, @RequestBody Products productsDetail) {
        Products updatedProduct = productsService.updateProducts(id, productsDetail);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productsService.deleteProducts(id);
        return ResponseEntity.noContent().build();
    }
}
