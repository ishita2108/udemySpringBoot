package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList();
	
	private static int tododsCount = 1;

	static {
		todos.add(new Todo(tododsCount++, "ishita", "Learn Java1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(tododsCount++, "gaurav", "Learn Spring1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(tododsCount++, "ishita", "Learn Spring Boot1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(tododsCount++, "ishita", "Learn React1", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username) ;
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		Todo todo = new Todo(tododsCount++, username, description, targetDate,isDone);
		todos.add(todo);
		
	}
	
	public void deleteById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId()== id;
		todos.removeIf(predicate);
	}

	public void updateById(int id) {
		
	}

	public Todo findById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId()== id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);	
	}

}
