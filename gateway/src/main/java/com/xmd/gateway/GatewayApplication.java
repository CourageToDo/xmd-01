package com.xmd.gateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableZuulProxy
@SpringCloudApplication
//@EnableSwagger2Doc
public class GatewayApplication {

	private static Logger logger = LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GatewayApplication.class);
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
