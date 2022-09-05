package com.example.todolisttailwind.backend.controller;

import com.example.todolisttailwind.backend.domain.Todo;
import com.example.todolisttailwind.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping(value = "/todos") //Rest API 용 컨트롤러로 만들 수 있음 => @ResponseBody를 뗄 수 있음.
@RequiredArgsConstructor //매개변수가 필요한 생성자들만 만들어줌.
//@AllArgsConstructor : 그냥 모든 생성자들을 만들어줌.
//@NoArgsConstructor : 매개변수가 없는 생성자들을 만들어줌.
public class TodoController {
    private final TodoService todoService;

    /*
    //@RequiredArgsConstructor 없을 때 => 이 작업을 Lombok이 해주는 것
    TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    */

    @GetMapping("")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }
    @PostMapping("")
    public List<Todo> createTodo(@RequestBody Todo todo){
        todoService.createTodo(todo);
        return todoService.getTodos();
    }

    //HTML method 가 많이 생김 => delete, put, patch 등
    @DeleteMapping("{id}")
    public List<Todo> deleteTodo(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        todoService.deleteTodo(id, response);
        return todoService.getTodos();
    }

    //수정 method : put, patch
    //put은 전부, patch는 일부
    @PatchMapping("{id}")
    public void checkTodo(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
        todoService.checkTodo(id, response);
    }

}
