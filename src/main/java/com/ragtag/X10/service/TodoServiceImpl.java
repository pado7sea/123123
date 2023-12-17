package com.ragtag.X10.service;

import java.util.List;

import com.ragtag.X10.model.dao.TodoDao;
import com.ragtag.X10.model.dto.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoDao todoDao;

    @Override
    public int insertTodo(TodoList todoList) {
        return todoDao.insertTodo(todoList);
    }

    @Override
    public List<TodoList> selectAll(String userId) {
        return todoDao.selectAll(userId);
    }

    @Override
    public int updateTodo(TodoList todoList) {
        return todoDao.updateTodo(todoList);
    }

    @Override
    public int deleteTodo(int todoId) {
        return todoDao.deleteTodo(todoId);
    }
}
