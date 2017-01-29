package com.github.tillkahlbrock.todo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.port;

@Configuration
@ComponentScan
public class Server
{
    private static final Logger logger = LogManager.getLogger(Server.class);

    public static void main(final String... args)
    {
        port(9884);
        ApplicationContext context = new AnnotationConfigApplicationContext(Server.class);
        TodoList todoList = context.getBean(TodoList.class);
        logger.trace("Starting to serve...");
        get("/tasks", (req, res) -> listToJsonString(todoList.allTasks()));
        logger.trace("Done!");
    }

    private static String listToJsonString(List list)
    {
        return "{[\"some\": \"thing\"]}";
    }
}
