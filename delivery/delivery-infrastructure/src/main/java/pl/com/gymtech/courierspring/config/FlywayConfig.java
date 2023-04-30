package pl.com.gymtech.courierspring.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Value("${spring.flyway.locations}")
    private String migrationLocation;

    @Autowired
    private Environment env;
    @Value("${spring.flyway.enabled}")
    private boolean flywayEnabled;

    @Bean
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource())
                .locations(migrationLocation)
                .load();
        if (flywayEnabled) {
            flyway.migrate();
        }
        return flyway;
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password")
        );
    }
}