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

    @Test
    void itShouldConvertTheTaskListToJson()
    {
        TodoList todoList = this.subject();
        String task1Id = todoList.addTask("Do something!");
        String task2Id = todoList.addTask("Do something else!");

        String expectedJson = "{\"tasks\":[{\"id\":\"" + task1Id + "\",\"title\":\"Do something!\",\"completed\":true},{\"id\":\"" + task2Id + "\",\"title\":\"Do something else!\",\"completed\":true}]}";
        assertEquals(expectedJson, todoList.toJson());
    }

    private TodoList subject() {
        return new TodoList();
    }
}
