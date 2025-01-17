package com.example.ccsd.WebsiteImages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WebsiteImagesService {


    @Autowired
    private final WebsiteImagesRepository websiteImagesRepository;

    public WebsiteImagesService(WebsiteImagesRepository imagesRepository){
        this.websiteImagesRepository = imagesRepository;
    }

    public List<WebsiteImages> getAllWebsiteImageses(){
        return websiteImagesRepository.findAll();
    }

    public Optional<WebsiteImages> getWebsiteImagesById(String id){
        return this.websiteImagesRepository.findById(id);
    }

    public WebsiteImages addWebsiteImages(WebsiteImages websiteImages){
        return websiteImagesRepository.save(websiteImages);
    }

    public WebsiteImages updateWebsiteImages(String id, WebsiteImages websiteImagesDetails){
        return websiteImagesRepository.findById(id).map(existingProduct -> {
            websiteImagesDetails.setId(existingProduct.getId());
            return websiteImagesRepository.save(websiteImagesDetails);
        }).orElse(null);
    }

    public void deleteWebsiteImages(String id){
        websiteImagesRepository.deleteById(id);
    }
}