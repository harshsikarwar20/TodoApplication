package com.example.TodoApplication.TodoController;

import com.example.TodoApplication.Todo.Todo;
import com.example.TodoApplication.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todos")
    private List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping(value = "/todo")
    private String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping(value = "/updateTodoById/{id}/{status}")
    private String updateTodo(@PathVariable String id , @PathVariable String status){
        return todoService.updateTodo(id , status);
    }

    @DeleteMapping(value = "/delete/todo/by/id/{id}")
    private String deleteTodo(@PathVariable String id){
        return todoService.deleteTodoById(id);
    }

    @RequestMapping(value = "/getTodoById/{id}" , method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoBasedOnId(id);
    }

}
