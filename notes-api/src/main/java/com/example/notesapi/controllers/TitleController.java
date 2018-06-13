package com.example.notesapi.controllers;


import com.example.notesapi.models.Title;
import com.example.notesapi.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;





@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TitleController {
    @Autowired
    private TitleRepository titleRepository;

    @GetMapping("/titles")
    public Iterable<Title> findAllTitles() {
        return titleRepository.findAll();
    }

    @GetMapping("/titles/{titleId}")
    public Title getTitleByName(@PathVariable Long titleId) {
        return titleRepository.findOne(titleId);
    }

    @DeleteMapping("/titles/{titleId}")
    public HttpStatus deleteTitleById(@PathVariable Long titleId) {
        titleRepository.delete(titleId);
        return HttpStatus.OK;
    }

    @PostMapping("/titles")
    public Title createNewTitle(@RequestBody Title newTitle) {
        return titleRepository.save(newTitle);
    }

    @PatchMapping("/titles/{titleId}")
    public Title updateUserById(@PathVariable Long titleId, @RequestBody Title titleRequest) {
        Title titleFromDb = titleRepository.findOne(titleId);
        titleFromDb.setText(titleRequest.getText());
        return titleRepository.save(titleFromDb);
    }
}
