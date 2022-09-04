package com.example.todolisttailwind.backend.service;

import com.example.todolisttailwind.backend.dao.TodoRepository;
import com.example.todolisttailwind.backend.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    public Todo createTodo(Todo todo){
        Todo newtodo = new Todo();
        newtodo.setContent(todo.getContent());
        newtodo.setChecked(false);
        todoRepository.save(newtodo);

        return newtodo;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
}
