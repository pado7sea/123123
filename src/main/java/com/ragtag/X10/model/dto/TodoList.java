package com.ragtag.X10.model.dto;

public class TodoList {
    private int todoId;
    private String userId;
    private int todoState;
    private String todo;

    public TodoList() {
    }

    public TodoList(int todoId, String userId, int todoState, String todo) {
        this.todoId = todoId;
        this.userId = userId;
        this.todoState = todoState;
        this.todo = todo;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTodoState() {
        return todoState;
    }

    public void setTodoState(int todoState) {
        this.todoState = todoState;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "todoId=" + todoId +
                ", userId='" + userId + '\'' +
                ", todoState=" + todoState +
                ", todo='" + todo + '\'' +
                '}';
    }
}
