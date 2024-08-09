package net.nikhilsinha.BloggingApp.service;

import net.nikhilsinha.BloggingApp.entity.BlogEntry;
import net.nikhilsinha.BloggingApp.repository.BlogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public void saveEntry(BlogEntry blogEntry){
        blogRepository.save(blogEntry);
    }

    public List<BlogEntry> getAll() {
        return blogRepository.findAll();
    }

    public Optional<BlogEntry> findById(ObjectId id){
        return blogRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        blogRepository.deleteById(id);
    }
}
