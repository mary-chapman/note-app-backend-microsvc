package com.example.notesapi.repositories;

import com.example.notesapi.models.Header;
import org.springframework.data.repository.CrudRepository;

public interface HeaderRepository  extends CrudRepository<Header, Long> {
}
