package com.example.ccsd.Gallery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends MongoRepository<Gallery, String> {
}

