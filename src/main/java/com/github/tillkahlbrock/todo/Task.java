package com.github.tillkahlbrock.todo;

import java.util.UUID;

class Task {

    private String title;
    private boolean active = true;
    private String id;

    Task(String title)
    {
        this.title = title;
        this.id = UUID.randomUUID().toString();
    }

    String title() {
        return title;
    }

    boolean isActive() {
        return this.active;
    }

    void deactivate()
    {
        this.active = false;
    }

    void activate() { this.active = true; }

    String getId() {
        return this.id;
    }
}
