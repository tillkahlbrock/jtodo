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

    List<Task> openTasks()
    {
        return this.tasks
                .stream()
                .filter(Task::isActive)
                .collect(Collectors.toList());
    }

    void removeTask(String taskId)
    {
        this.tasks = this.tasks.stream().filter(task -> !task.getId().equals(taskId)).collect(Collectors.toList());
    }

    String completeTask(String id)
    {
        this.tasks = this.tasks
                .stream()
                .map(task -> {
                    if(task.getId().equals(id)) {
                        task.deactivate();
                        return task;
                    }
                    return task;
                })
                .collect(Collectors.toList());

        return id;
    }

    String toJson()
    {
        String jsonElements = this.tasks
                .stream()
                .filter(Task::isActive)
                .map(task -> "{\"id\":\"" + task.getId() + "\",\"title\":\"" + task.title() + "\",\"completed\":" + (task.isActive() ? "true" : "false") + "}")
                .collect(Collectors.joining(","));
        return "{\"tasks\":[" + jsonElements + "]}";
    }
}
