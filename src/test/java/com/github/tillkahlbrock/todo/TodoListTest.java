package com.github.tillkahlbrock.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoListTest
{
    @Test
    void itShouldAllowToAddATaskWithTheGivenTitle() {
        TodoList todoList = this.subject();
        todoList.addTask("Do something!");
        todoList.addTask("Do something else!");
        assertEquals(2, todoList.allTasks().size());
        assertEquals("Do something!", todoList.allTasks().get(0).title());
    }

    @Test
    void itShouldAllowToRemoveASpecificTask()
    {
        TodoList todoList = this.subject();
        todoList.addTask("Do something!");
        String taskId = todoList.addTask("Do something else!");
        todoList.removeTask(taskId);
        assertEquals(1, todoList.allTasks().size());
    }

    private TodoList subject() {
        return new TodoList();
    }
}
