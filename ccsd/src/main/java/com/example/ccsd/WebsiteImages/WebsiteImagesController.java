package com.example.ccsd.WebsiteImages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
@RequestMapping("/api/WebsiteImage")
public class WebsiteImagesController {

       @Autowired
    private WebsiteImagesService websiteImagesService;

    @GetMapping
    public List<WebsiteImages> getAllWebsiteImageses() {
        List<WebsiteImages> websiteImagesList = websiteImagesService.getAllWebsiteImageses();
        return websiteImagesList.stream()
            .map((websiteImages) -> {

                websiteImages.setImage64String(websiteImages.getImage64String());
                return websiteImages;
            })
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebsiteImages> getWebsiteImagesById(@PathVariable String id) {
        return websiteImagesService.getWebsiteImagesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
         public ResponseEntity<Map<String, Object>> addWebsiteImages(
            @RequestParam("title") String title,
            @RequestParam("postShortDescription") String postShortDescription,
            @RequestParam("date") String date,
            @RequestParam("status") String status,
            @RequestParam("tag") String tag,
            @RequestParam("place") String place,
            @RequestParam("content") String content,
            @RequestParam("postSlug") String postSlug,

            @RequestParam("image") MultipartFile image) throws IOException {

        // Convert the image to a byte array
        byte[] imageBytes = image.getBytes();  // Get image data

        // Create a new Product instance
        WebsiteImages websiteImages = new WebsiteImages();
        websiteImages.setTitle(title);
        websiteImages.setpostShortDescription(postShortDescription);
        websiteImages.setDate(date);
        websiteImages.setTag(tag);
        websiteImages.setPlace(place);
        websiteImages.setStatus(status);
        websiteImages.setContent(content);
        websiteImages.setPostSlug(postSlug);
        websiteImages.setimage(imageBytes);  // Store image as byte array

        // Save the product in MongoDB
        WebsiteImages savedwebsiteImages = websiteImagesService.addWebsiteImages(websiteImages);

        // Return a response
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("product", savedwebsiteImages);
        
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebsiteImages> updateWebsiteImages(@PathVariable String id, @RequestBody WebsiteImages websiteImagesDetails) {
        WebsiteImages updatedBook = websiteImagesService.updateWebsiteImages(id, websiteImagesDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWebsiteImages(@PathVariable String id) {
       websiteImagesService.deleteWebsiteImages(id);
        return ResponseEntity.noContent().build();
    }
}