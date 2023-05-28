package pl.com.gymtech.courierspring.config;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    @Bean(initMethod = "migrate")
    Flyway flyway(final DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("db/migration")
                .load();
    }
}