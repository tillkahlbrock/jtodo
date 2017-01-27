package com.github.tillkahlbrock.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoListTest
{
    @Test
    void itShouldAddATaskWithTheGivenTitle() {
        TodoList todoList = this.subject();
        todoList.addTask("Do something!");
        assertEquals(1, todoList.allTasks().size());
        assertEquals("Do something!", todoList.allTasks().get(0).title());
    }

    private TodoList subject() {
        return new TodoList();
    }
}
