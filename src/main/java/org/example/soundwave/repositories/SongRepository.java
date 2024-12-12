package org.example.soundwave.repositories;

import org.example.soundwave.entities.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
