package com.ragtag.X10.model.dao;

import com.ragtag.X10.model.dto.TodoList;

import java.util.List;

public interface TodoDao {
    List<TodoList> selectAll(String userId);

    int insertTodo(TodoList todoList);

    int updateTodo(TodoList todoList);

    int deleteTodo(int todoId);
}
