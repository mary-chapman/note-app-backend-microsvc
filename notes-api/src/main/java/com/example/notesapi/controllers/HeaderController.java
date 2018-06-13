package com.example.notesapi.controllers;

import com.example.notesapi.models.Header;
import com.example.notesapi.repositories.HeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class HeaderController {
    @Autowired
    private HeaderRepository headerRepository;

    @GetMapping("/headers")
    public Iterable<Header> findAllHeaders() {
        return headerRepository.findAll();
    }

    @GetMapping("/headers/{headerId}")
    public Header getHeaderById(@PathVariable Long headerId) {
        return headerRepository.findOne(headerId);
    }

    @PostMapping("/headers")
    public Header createNewUser(@RequestBody Header newHeader) {
        return headerRepository.save(newHeader);
    }

    @DeleteMapping("/headers/{headerId}")
    public HttpStatus deleteHeaderById(@PathVariable Long headerId) {
        headerRepository.delete(headerId);
        return HttpStatus.OK;
    }

    @PatchMapping("/headers/{headerId}")
    public Header updateHeaderById(@PathVariable Long headerId, @RequestBody Header headerRequest) {

        Header headerFromDb = headerRepository.findOne(headerId);
        headerFromDb.setText(headerRequest.getText());
        return headerRepository.save(headerFromDb);

    }
}
