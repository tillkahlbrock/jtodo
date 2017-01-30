package com.github.tillkahlbrock.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
class TodoList {
    private List<Task> tasks = new ArrayList<Task>();

    String addTask(String title)
    {
        Task task = new Task(title);
        tasks.add(task);
        return task.getId();
    }

    List<Task> allTasks() {
        return this.tasks;
    }

    void removeTask(String taskId)
    {
        this.tasks = this.tasks.stream().filter(task -> !task.getId().equals(taskId)).collect(Collectors.toList());
    }

    String toJson()
    {
        String jsonElements = this.tasks
                .stream()
                .map(task -> "{\"id\":\"" + task.getId() + "\",\"title\":\"" + task.title() + "\"}")
                .collect(Collectors.joining(","));
        return "{\"tasks\":[" + jsonElements + "]}";
    }
}
