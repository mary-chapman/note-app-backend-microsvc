package com.example.notesapi.repositories;

import com.example.notesapi.models.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<Title, Long> {
}
