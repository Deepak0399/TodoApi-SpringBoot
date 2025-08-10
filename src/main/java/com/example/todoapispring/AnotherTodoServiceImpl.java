package com.example.todoapispring;

import org.springframework.stereotype.Service;

@Service("anotherTodoService")
public class AnotherTodoServiceImpl implements TodoService {
    @TimeMonitor
    //join point
    public String doSomething() {
        for (long i = 0; i < 1000000000L; i++) {
            //....
        }
        return "Something From Another Todo";
    }
}
