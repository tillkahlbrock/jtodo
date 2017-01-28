package com.github.tillkahlbrock.todo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static spark.Spark.get;
import static spark.Spark.port;

public class Server
{
    private static final Logger logger = LogManager.getLogger(Server.class);
    public static void main(final String... args)
    {
        logger.trace("Starting to serve...");
        get("/hello", (req, res) -> "Hello World");
        logger.trace("Done!");
    }
}
