package com.example.todolisttailwind.backend.service;

import com.example.todolisttailwind.backend.dao.TodoRepository;
import com.example.todolisttailwind.backend.domain.Todo;
import com.example.todolisttailwind.backend.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public void deleteTodo(Integer id, HttpServletResponse response) throws IOException {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            todoRepository.deleteById(id);
        }
        else{ //해당 id의 값이 없으면 404 에러 내기
            //에러 response
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setCode("F-1");
            responseDTO.setMessage("이미 삭제된 할 일입니다.");
            response.setStatus(404);
            //에러 헤더 필요
            response.setHeader("content-type", "application/json;charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(), responseDTO);

        }


    }
}
