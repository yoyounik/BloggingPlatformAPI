package net.nikhilsinha.BloggingApp.repository;

import net.nikhilsinha.BloggingApp.entity.BlogEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<BlogEntry, ObjectId> {

}
