package pl.com.gymtech.courierspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Assert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.com.gymtech.courierspring.api.CustomersApiController;
import pl.com.gymtech.courierspring.config.DataSourceConfig;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.entity.Customer;
import pl.com.gymtech.courierspring.repository.CustomerRepository;
import pl.com.gymtech.courierspring.service.CustomerService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.util.Optional;
import java.util.regex.Matcher;


@ExtendWith(SpringExtension.class)
@SpringBootTest

@SqlGroup(@Sql({ "classpath:/drop_schema.sql", "classpath:/create_schema.sql" })
)
public class DataRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired private EntityManager entityManager;
    @Autowired private CustomerRepository customerRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(customerRepository).isNotNull();

    }


    @Test
    public void givenWac_whenServletContext_thenItProvidesCustomerController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(webApplicationContext.getBean("customersApiController"));
    }



}



