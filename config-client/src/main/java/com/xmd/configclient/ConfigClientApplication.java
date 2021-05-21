package com.xmd.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ConfigClientApplication {

    private static Logger logger = LoggerFactory.getLogger(ConfigClientApplication.class);

    public static void main(String[] args) {

//        SpringApplication.run(ConfigClientApplication.class, args);
//        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);

        SpringApplication app = new SpringApplication(ConfigClientApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        try {
            logger.info("\n----------------------------------------------------------\n\t" +
                            "Application '{}' is running! Access URLs:\n\t" +
                            "Local: \t\t{}://localhost:{}\n\t" +
                            "External: \t{}://{}:{}\n\t" +
                            "swagger: \t{}://localhost:{}/swagger-ui.html\n----------------------------------------------------------",
                    env.getProperty("spring.application.name"),
                    protocol,
                    env.getProperty("server.port"),
                    protocol,
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port"),
                    protocol,
                    env.getProperty("server.port"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
