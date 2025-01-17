package com.example.ccsd.Gallery;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Gallery")

public class GalleryController {

    @Autowired
    private com.example.ccsd.Gallery.GalleryService GalleryService;

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllGallerys() {
        List<Gallery> galleryList = GalleryService.getAllGallerys();
        return ResponseEntity.ok(galleryList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGalleryById(@PathVariable String id) {
        return GalleryService.getGalleryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addGallery(
            @RequestParam("title") String title,
            @RequestParam("postSlug") String postSlug,
            @RequestParam("postShortDescription") String postShortDescription,
            @RequestParam("tag") String tag,
            @RequestParam("place") String place,
            @RequestParam("date") String date,
            @RequestParam("status") String status,
            @RequestParam("content") String content,
            @RequestParam("image") MultipartFile image) throws IOException {

        byte[] imageBytes = image.getBytes();
        String base64String = Base64.getEncoder().encodeToString(imageBytes);

        Gallery Gallery = new Gallery();
        Gallery.setTitle(title);
        Gallery.setPostSlug(postSlug);
        Gallery.setPostShortDescription(postShortDescription);
        Gallery.setTag(tag);
        Gallery.setPlace(place);
        Gallery.setDate(date);
        Gallery.setStatus(status);
        Gallery.setImage(base64String);
        Gallery.setContent(content);

        Gallery savedGallery = GalleryService.addGallery(Gallery);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("product", savedGallery);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gallery> updategallery(@PathVariable String id, @RequestBody Gallery GalleryDetails) {
        Gallery updatedgallery = GalleryService.updateGallery(id, GalleryDetails);
        if (updatedgallery != null) {
            return ResponseEntity.ok(updatedgallery);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletegallery(@PathVariable String id) {
        GalleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }
}
