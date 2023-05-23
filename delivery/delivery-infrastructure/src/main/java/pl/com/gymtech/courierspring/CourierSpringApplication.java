package pl.com.gymtech.courierspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CourierSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourierSpringApplication.class, args);
    }

}
