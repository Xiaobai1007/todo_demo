package com.nf147.todo.mapper;

import com.nf147.todo.entity.Todo;

import java.util.List;

public interface TodoMapper {
    List<Todo> getTodos();
    int addTodo(Todo todo);
    int deleteTodo(Todo todo);
    int makeDone(Todo todo);
    void makeCancle(Todo todo);
}
