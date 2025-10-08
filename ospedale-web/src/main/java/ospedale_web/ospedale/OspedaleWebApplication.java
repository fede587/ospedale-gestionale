package ospedale_web.ospedale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ospedale.ospedale")
@EntityScan(basePackages = "ospedale.ospedale_core.entità")
public class OspedaleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(OspedaleWebApplication.class, args);
    }
}
