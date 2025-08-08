package com.example.todoapispring;

import org.springframework.stereotype.Service;

@Service("anotherTodoService")
public class AnotherTodoServiceImpl implements TodoService {
    @Override
    public String doSomething() {
        return "Something From Another Todo";
    }
}
