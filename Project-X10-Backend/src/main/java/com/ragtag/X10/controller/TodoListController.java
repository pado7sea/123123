package com.ragtag.X10.controller;

import com.ragtag.X10.model.dto.TodoList;
import com.ragtag.X10.model.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/todolist")
public class TodoListController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<?> newTodo(@RequestBody TodoList todoList) {
        int result = todoService.insertTodo(todoList);

        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/AllTodo/{userId}")
    public ResponseEntity<?> selectAll(@PathVariable("userId") String userId) {
        List<TodoList> todoList = todoService.selectAll(userId);
        if (todoList == null || todoList.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTodo(@RequestBody TodoList todoList) {
        int result = todoService.updateTodo(todoList);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable("todoId") int todoId) {
        int result = todoService.deleteTodo(todoId);
        if (result == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
