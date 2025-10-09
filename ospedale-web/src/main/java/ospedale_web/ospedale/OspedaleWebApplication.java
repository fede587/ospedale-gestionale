package ospedale_web.ospedale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ospedale.ospedale")
@EntityScan(basePackages = "ospedale.ospedale_core.entità")
@EnableJpaRepositories(basePackages = "ospedale.ospedale_core.repository")

public class OspedaleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(OspedaleWebApplication.class, args);
    }
}
