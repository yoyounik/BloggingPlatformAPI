package net.nikhilsinha.BloggingApp.controller;

import net.nikhilsinha.BloggingApp.entity.BlogEntry;
import net.nikhilsinha.BloggingApp.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
   @Autowired
   private BlogService blogService;

    @GetMapping("/Blog")
    public List<BlogEntry> getAll(){
        return blogService.getAll();
    }

    @PostMapping("/Blog")
    public BlogEntry createEntry(@RequestBody BlogEntry myEntry){
        myEntry.setCreatedAt(LocalDateTime.now());
        blogService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public BlogEntry getBlogEntriesById(@PathVariable ObjectId myId){
       return blogService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteBlogEntriesById(@PathVariable ObjectId myId){
        blogService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public BlogEntry updateEntriesById(@PathVariable ObjectId myId, @RequestBody BlogEntry newEntry){
        BlogEntry old = blogService.findById(myId).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setCategory(newEntry.getCategory() != null && !newEntry.getCategory().equals("") ? newEntry.getCategory() : old.getCategory());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        blogService.saveEntry(old);
        return old;
    }
}
