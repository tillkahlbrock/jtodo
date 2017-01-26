package com.github.tillkahlbrock.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks = new ArrayList<Task>();

    public void addTask(String title)
    {
        tasks.add(new Task(title));
    }

    public List<Task> allTasks() {
        return this.tasks;
    }
}
