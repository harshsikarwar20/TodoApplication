package com.example.TodoApplication.TodoService;

import com.example.TodoApplication.Todo.Todo;
import com.example.TodoApplication.TodoDao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;
    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    public String addTodo(Todo todo) {
        Boolean status = todoDao.addTodo(todo);
        if(status){
            return "Yes added";
        }else{
            return "Not added";
        }
    }

    public String deleteTodoById(String id) {
        if(id != null){
            List<Todo> listRightNow =  todoDao.getAllTodos();
            for(Todo todo :listRightNow){
                if(todo.getId().equals(id)){
                    Boolean status = todoDao.remove(todo);

                    if(status){
                        return "Deleted";
                    }
                }
            }
        }
        return "Not Deleted";
    }

    public String updateTodo(String id , String status) {
        boolean updateStatus = todoDao.update(id , Boolean.parseBoolean(status));
        if(updateStatus){
            return "Updated...";
        }else{
            return "Not Updated...";
        }
    }

    public Todo getTodoBasedOnId(String id) {
        List<Todo> todoListRightNow = todoDao.getAllTodos();

        for(Todo todo : todoListRightNow){
            if(todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }
}
