package com.project.todolistappinterface.services;

import com.project.todolistappinterface.model.TodoItem;
import com.project.todolistappinterface.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {


    @Autowired
    private TodoItemRepository todoItemRepository;


    //1. Metodo Get all
    public List<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }

    //2. Metodo Get By id
    public Optional<TodoItem> getById(Long id){
        return todoItemRepository.findById(id);
    }

    //3. Guardar un registro nuevo
    public TodoItem save(TodoItem todoItem){
        //Verificacion de si el id es null, se registrará un nuevo elemento
        if (todoItem.getId() == null){
            todoItem.setCreatedAt(Instant.now());
        }

        todoItem.setUpdatedAt(Instant.now());

        return todoItemRepository.save(todoItem);
    }

    //4. Eliminar
    public void delete(TodoItem todoItem){
        todoItemRepository.delete(todoItem);
    }
}
