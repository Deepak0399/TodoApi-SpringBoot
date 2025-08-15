# Todo API Spring

A simple RESTful API for managing todo items built with Spring Boot.

## Project Overview

This project is a Todo API that allows users to create, retrieve, and manage todo items. It demonstrates the use of Spring Boot, RESTful API design, dependency injection, and aspect-oriented programming (AOP).

## Technologies Used

- Java 17
- Spring Boot 3.5.4
- Spring Web (for RESTful API)
- Spring AOP (for aspect-oriented programming)
- AspectJ (for implementing aspects)
- Gradle (for build and dependency management)

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Gradle

### Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd TodoApiSpring
   ```

3. Build the project:
   ```
   ./gradlew build
   ```

4. Run the application:
   ```
   ./gradlew bootRun
   ```

The application will start on `http://localhost:8080`.

## API Endpoints

- `GET /api/v1/todos`: Get all todos (can filter by completion status using the `isCompleted` query parameter)
- `POST /api/v1/todos`: Create a new todo
- `GET /api/v1/todos/{todoId}`: Get a specific todo by ID

## Custom Annotation: TimeMonitor

This project includes a custom annotation called `TimeMonitor` that is used to measure and log the execution time of methods.

### How it Works

1. **Annotation Definition**: The `TimeMonitor` annotation is defined in `TimeMonitor.java`. It's a method-level annotation that is retained at runtime.

2. **Aspect Implementation**: The functionality of the annotation is implemented in `TimeMonitorAspect.java` using Spring AOP. The aspect intercepts method calls annotated with `@TimeMonitor` and measures the execution time.

3. **Usage**: To use the annotation, simply add `@TimeMonitor` to any method you want to monitor:

   ```java
   @TimeMonitor
   public void someMethod() {
       // Method implementation
   }
   ```

   When this method is called, the aspect will log the execution time in milliseconds.

### Example

In this project, the `doSomething()` method in both `TodoServiceImpl` and `AnotherTodoServiceImpl` is annotated with `@TimeMonitor`. These methods contain a loop that runs a billion times, which takes some time to execute. The aspect measures and logs the execution time of these methods.

## Project Structure

- `Todo.java`: The model class representing a todo item
- `TodoService.java`: The service interface
- `TodoServiceImpl.java`: One implementation of the service interface
- `AnotherTodoServiceImpl.java`: Another implementation of the service interface
- `TodoController.java`: The REST controller that handles HTTP requests
- `TimeMonitor.java`: The custom annotation
- `TimeMonitorAspect.java`: The aspect that implements the functionality of the annotation
- `TodoApiSpringApplication.java`: The main application class
