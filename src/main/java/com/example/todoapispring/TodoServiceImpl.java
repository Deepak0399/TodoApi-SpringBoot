package com.example.todoapispring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("todoService")
public class TodoServiceImpl implements TodoService {
    @Override
    public String doSomething() {
        return"Something";
    }
}
