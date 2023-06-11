package pl.com.gymtech.courierspring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.WebApplicationContext;
import pl.com.gymtech.courierspring.mapper.CustomerMapper;
import pl.com.gymtech.courierspring.repository.CustomerRepository;
import pl.com.gymtech.courierspring.service.CustomerService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.sql.DataSource;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@SqlGroup(@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:/drop-schema.sql", "classpath:/create-schema.sql", "classpath:/insert-Customer-schema.sql"})
)
public class DataRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired private CustomerMapper customerMapper;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(customerRepository).isNotNull();
        assertThat(platformTransactionManager).isNotNull();

    }


    @Test
    public void givenWac_whenServletContext_thenItProvidesCustomerController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(webApplicationContext.getBean("customersApiController"));
    }

    /*@Test
    public void optimisticLockTest() throws InterruptedException {
        Customer customer = new Customer();
        customerRepository.save(customer);

        final List<String> names = Arrays.asList("Jan", "Janusz", "Mateusz");
        final ExecutorService executor = Executors.newFixedThreadPool(names.size());

        for (final String name : names) {
            customer.setFirstName(name);
            System.out.println(customer.getFirstName());
            executor.execute(() -> customerService.updateCustomer(customer.getId(),customerMapper.customerToCustomerDTO(customer)) );
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("LKKKKKK");
        Customer customer1 = customerRepository.findById(customer.getId()).orElseThrow();
        assertEquals(2, customer.getVersion());


    }*/

}



