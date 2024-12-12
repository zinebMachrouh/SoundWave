package org.example.soundwave.repositories;

import org.example.soundwave.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
