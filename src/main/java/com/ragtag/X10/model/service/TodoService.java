package com.ragtag.X10.model.service;

import com.ragtag.X10.model.dto.TodoList;

import java.util.List;

public interface TodoService {
    int insertTodo(TodoList todoList);

    List<TodoList> selectAll(String userId);

    int updateTodo(TodoList todoList);

    int deleteTodo(int todoId);
}