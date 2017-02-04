package com.github.tillkahlbrock.todo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static spark.Spark.*;

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
        get("/tasks", (req, res) -> todoList.toJson());
        post("/task", (req, res) -> todoList.addTask(req.queryParams("title")));
        logger.trace("Done!");
    }
}
