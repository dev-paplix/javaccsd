package com.example.ccsd.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public List<Gallery> getAllGallerys() {
        return galleryRepository.findAll();
    }

    public Optional<Object> getGalleryById(String id) {
        return Optional.of(galleryRepository.findById(id));
    }

    @Transactional
    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Transactional
    public Gallery updateGallery(String id, Gallery galleryDetails) {
        try {
            Optional<Gallery> galleryOptional = galleryRepository.findById(id);
            if (galleryOptional.isEmpty())
                throw new UserNotFoundException("User does not exists!");
            return galleryOptional.get();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteGallery(String id) {
        galleryRepository.deleteById(id);
    }
}
