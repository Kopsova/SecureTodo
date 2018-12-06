package com.example.securetodo.Repositories;

import com.example.securetodo.Models.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<ToDo, Long> {
    @Override
    List<ToDo> findAll();
}