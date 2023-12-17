package com.ragtag.X10.model.dao;

import java.util.*;

import com.ragtag.X10.model.dto.TodoList;

public interface TodoDao {
    List<TodoList> selectAll(String userId);

    int insertTodo(TodoList todoList);

    int updateTodo(TodoList todoList);

    int deleteTodo(int todoId);
}
