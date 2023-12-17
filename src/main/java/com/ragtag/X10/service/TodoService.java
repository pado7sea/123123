package com.ragtag.X10.service;

import java.util.*;

import com.ragtag.X10.model.dto.TodoList;

public interface TodoService {
    int insertTodo(TodoList todoList);

    List<TodoList> selectAll(String userId);

    int updateTodo(TodoList todoList);

    int deleteTodo(int todoId);
}