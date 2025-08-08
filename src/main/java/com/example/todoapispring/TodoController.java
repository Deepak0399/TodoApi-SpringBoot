package com.example.todoapispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {


    private final TodoService todoService;
    private final TodoService todoService2;
    private static final String TODO_NOT_FOUND = "Todo not found";
    private static List<Todo> todoList;
    public TodoController( @Qualifier("todoService") TodoService todoService,
                           @Qualifier("anotherTodoService") TodoService todoService2){

        this.todoService = todoService;
        this.todoService2 = todoService2;
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,false,"Todo 1", 1));
        todoList.add(new Todo(2,true,"Todo 2", 2));
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam (required = false) Boolean isCompleted) {
        System.out.println(isCompleted + this.todoService.doSomething()+" & "+ this.todoService2.doSomething());
        return ResponseEntity.ok(todoList);
    }
    @PostMapping
    /*
       we can use this annotation to set the status code     @ResponseStatus(HttpStatus.CREATED)
     */
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
//        return newTodo;
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }
//    @PostMapping("/todos")
//    public Todo createTodo1(@RequestBody Todo newTodo) {
//        todoList.add(newTodo);
//        return newTodo;
//    }
    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable long todoId) {
        for (Todo todo : todoList) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
    }
}
