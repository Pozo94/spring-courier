package pl.com.gymtech.courierspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.com.gymtech.courierspring.config.FileStorageProperties;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class CourierSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourierSpringApplication.class, args);
    }

}
