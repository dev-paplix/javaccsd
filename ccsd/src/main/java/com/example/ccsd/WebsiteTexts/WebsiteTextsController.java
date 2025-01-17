package com.example.ccsd.WebsiteTexts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/website-texts")
public class WebsiteTextsController {

    @Autowired
    private WebsiteTextsService websiteTextsService;

    @GetMapping
    public List<WebsiteTexts> getAllText() {
        return websiteTextsService.getAllText();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebsiteTexts> getTextById(@PathVariable String id) {
        return websiteTextsService.getTextById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WebsiteTexts addText(@RequestBody WebsiteTexts websiteTexts) {
        return websiteTextsService.addText(websiteTexts);
    }

     @PutMapping("/{id}")
    public ResponseEntity<WebsiteTexts> updateText(@PathVariable String id, @RequestBody WebsiteTexts textDetails) {
        WebsiteTexts updatedText = websiteTextsService.updateText(id, textDetails);
        if (updatedText != null) {
            return ResponseEntity.ok(updatedText);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteText(@PathVariable String id) {
        websiteTextsService.deleteText(id);
        return ResponseEntity.noContent().build();
    }
}


