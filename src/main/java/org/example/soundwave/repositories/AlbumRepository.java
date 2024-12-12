package org.example.soundwave.repositories;

import org.example.soundwave.entities.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}
