package com.example.todoapispring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("todoService")
public class TodoServiceImpl implements TodoService {
    @TimeMonitor
    @Override
    //join point
    public String doSomething() {
        for (long i = 0; i < 1000000000L; i++) {
            //....
        }
        return"Something from TodoService";
    }
}
