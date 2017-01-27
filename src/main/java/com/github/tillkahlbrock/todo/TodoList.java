package com.github.tillkahlbrock.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private List<Task> tasks = new ArrayList<Task>();

    public String addTask(String title)
    {
        Task task = new Task(title);
        tasks.add(task);
        return task.getId();
    }

    public List<Task> allTasks() {
        return this.tasks;
    }

    public void removeTask(String taskId)
    {
        this.tasks = this.tasks.stream().filter(task -> !task.getId().equals(taskId)).collect(Collectors.toList());
    }
}
