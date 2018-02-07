package net.emisia.svn2git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Svn2GitApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(Svn2GitApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder Svn2GitApplication) {
	return Svn2GitApplication.sources(Svn2GitApplication.class);
    }

}
