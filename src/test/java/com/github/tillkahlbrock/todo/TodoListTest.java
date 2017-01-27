package com.github.tillkahlbrock.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest
{
    @Test
    void itShouldAddATaskWithTheGivenTitle() {
        TodoList todoList = aTodoListWithOneTask("Do something!");
        assertEquals(1, todoList.allTasks().size());
        assertEquals("Do something!", todoList.allTasks().get(0).title());
    }

    @Test
    void itShouldActivateATaskWhenAdded()
    {
        TodoList todoList = aTodoListWithOneTask();
        Task task = todoList.allTasks().get(0);
        assertTrue(task.isActive());
    }

    @Test
    void itShouldDeactivateASpecificTask()
    {
        TodoList todoList = this.aTodoListWithOneTask();
        Task task = todoList.allTasks().get(0);
        task.deactivate();
        assertFalse(task.isActive());
    }

    private TodoList aTodoListWithOneTask()
    {
        return this.aTodoListWithOneTask("Some title");
    }

    private TodoList aTodoListWithOneTask(String title)
    {
        TodoList todoList = this.subject();
        todoList.addTask(title);
        return todoList;
    }

    private TodoList subject() {
        return new TodoList();
    }
}
