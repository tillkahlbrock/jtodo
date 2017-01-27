package com.github.tillkahlbrock.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest
{
    @Test
    void itShouldActivateANewlyCreatedTaks()
    {
        Task task = new Task("Some Task");
        assertTrue(task.isActive());
    }

    @Test
    void itShouldAllowToDeactivateATask()
    {
        Task task = new Task("Some Task");
        task.deactivate();
        assertFalse(task.isActive());
    }

    @Test
    void itShouldAllowToActivateTaskAgain()
    {
        Task task = new Task("Some Task");
        task.deactivate();
        task.activate();
        assertTrue(task.isActive());
    }

}
