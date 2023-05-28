package pl.com.gymtech.courierspring;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.gymtech.courierspring.entity.Customer;
import pl.com.gymtech.courierspring.repository.CustomerRepository;
import static org.assertj.core.api.Assertions.assertThat;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest

public class CustomerDataRepositoryTest {
    @Autowired
    private DataSource dataSource;
   // @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private CustomerRepository customerRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        //assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(customerRepository).isNotNull();
    }
    @Test
    public void shouldAddCustomer() {
        final Customer entity = new Customer();
        final Customer save = customerRepository.save(entity);
        final Optional<Customer> newCustomer = customerRepository.findById(save.getId());
        assertThat(newCustomer.isPresent()).isTrue();
        customerRepository.deleteById(save.getId());
        //
        final Optional<Customer> deletedById = customerRepository.findById(save.getId());
        assertThat(deletedById.isEmpty()).isTrue();
    }
}



