package com.github.tillkahlbrock.todo;

class Task {

    private String title;
    private boolean active = true;

    Task(String title)
    {
        this.title = title;
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
}
