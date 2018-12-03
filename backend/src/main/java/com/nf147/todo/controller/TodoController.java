package com.nf147.todo.controller;

import com.nf147.todo.entity.Todo;
import com.nf147.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> home () {
        return todoMapper.getTodos();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String add (@RequestBody Todo todo) {
        return todoMapper.addTodo(todo) > 0 ? "{\"msg\":\"添加成功\"}": "{\"msg\":\"添加失败\"}";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String del (@RequestBody Todo todo) {
        return todoMapper.deleteTodo(todo) > 0 ? "{\"msg\":\"删除成功\"}": "{\"msg\":\"删除失败\"}";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String update (@RequestBody Todo todo) {
        return todoMapper.makeDone(todo) > 0 ? "{\"msg\":\"修改成功\"}": "{\"msg\":\"修改失败\"}";
    }
}
