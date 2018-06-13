package com.example.notesapi.controllers;

import com.example.notesapi.models.Codeblock;
import com.example.notesapi.repositories.CodeblockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CodeBlockController {
    @Autowired
    private CodeblockRepository codeblockRepository;

    @GetMapping("/codeblocks")
    public Iterable<Codeblock> findAllCodeblocks() {
        return codeblockRepository.findAll();
    }

    @GetMapping("/codeblocks/{codeblockId}")
    public Codeblock getCodeblockById(@PathVariable Long codeblockId) {
        return codeblockRepository.findOne(codeblockId);
    }

    @DeleteMapping("/codeblocks/{codeblockId}")
    public HttpStatus deleteCodeblockById(@PathVariable Long codeblockId) {
        codeblockRepository.delete(codeblockId);
        return HttpStatus.OK;
    }

    @PatchMapping("/codeblocks/{codeblockId}")
    public Codeblock updateUserById(@PathVariable Long codeblockId, @RequestBody Codeblock codeblockRequest) {

        Codeblock codeblockFromDb = codeblockRepository.findOne(codeblockId);
        codeblockFromDb.setText(codeblockRequest.getText());
        return codeblockRepository.save(codeblockFromDb);
    }

    @PostMapping("/codeblocks")
    public Codeblock createCodeblock(@RequestBody Codeblock newCodeblock) {
        return codeblockRepository.save(newCodeblock);
    }
}
