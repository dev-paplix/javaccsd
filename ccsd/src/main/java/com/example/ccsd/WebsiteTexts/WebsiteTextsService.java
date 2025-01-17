package com.example.ccsd.WebsiteTexts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteTextsService {

    @Autowired
    private WebsiteTextsRepository websiteTextsRepository;

    // Get all texts
    public List<WebsiteTexts> getAllText() {
        return websiteTextsRepository.findAll();
    }

    // Get a specific text by ID
    public Optional<WebsiteTexts> getTextById(String id) {
        return websiteTextsRepository.findById(id);
    }

    // Add a new text
    public WebsiteTexts addText(WebsiteTexts websiteTexts) {
        return websiteTextsRepository.save(websiteTexts);
    }

    // Update an existing text by ID
    public WebsiteTexts updateText(String id, WebsiteTexts textDetails) {
        // Check if the text exists
        Optional<WebsiteTexts> existingTextOpt = websiteTextsRepository.findById(id);
        if (existingTextOpt.isPresent()) {
            WebsiteTexts existingText = existingTextOpt.get();
            // Update fields
            existingText.setAuthor(textDetails.getAuthor());
            existingText.setPostShortDescription(textDetails.getPostShortDescription());
            existingText.setTag(textDetails.getTag());
            existingText.setPlace(textDetails.getPlace());
            existingText.setTitle(textDetails.getTitle());
            existingText.setPostSlug(textDetails.getPostSlug());
            existingText.setContent(textDetails.getContent());
            existingText.setStatus(textDetails.getStatus());
            existingText.setDate(textDetails.getDate());
            existingText.setImage(textDetails.getImage());

            return websiteTextsRepository.save(existingText);
        }
        return null;
    }

    // Delete a text by ID
    public void deleteText(String id) {
        websiteTextsRepository.deleteById(id);
    }
}
