package pl.com.gymtech.courierspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.com.gymtech.courierspring.api.CustomersApiController;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.entity.Customer;
import pl.com.gymtech.courierspring.repository.CustomerRepository;
import pl.com.gymtech.courierspring.repository.OrderRepository;
import pl.com.gymtech.courierspring.service.CustomerService;


import javax.persistence.OptimisticLockException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest

@SqlGroup(@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:/drop-schema.sql", "classpath:/create-schema.sql", "classpath:/insert-Customer-schema.sql", "classpath:/insert-Order-schema.sql"})
)
public class CustomerTest {
    private MockMvc mockMvc;
    @Autowired
    private CustomersApiController customersApiController;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired private CustomerService customerService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    private static final String TEST_ID="93a35482-aa55-4b5d-b53f-68a14e1f6152";
    @Test
    public void shouldAddCustomerTest() throws Exception {

        Long count=customerRepository.count();
        assertEquals(count,3);
        CustomerDTO requestBody = new CustomerDTO();
        requestBody.setFirstName("Antoni");
        requestBody.setLastName("Sobieski");
        requestBody.setAddress("Krakow");
        requestBody.setEmail("sobieski@poczta.fm");
        requestBody.setPhone("876654567");

        mockMvc.perform(post("/api/customers/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk());
        count=customerRepository.count();
        assertEquals(count,4);

    }
    @Test
    public void shouldGetCustomerTest() throws Exception {
        Customer customer = customerRepository.findById(TEST_ID).orElseThrow();
        assertEquals(customer.getFirstName(),"Jacek");
        this.mockMvc
                .perform(get("/api/customers/{id}", TEST_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.firstName").value("Jacek"));

    }
    @Test
    public void shouldGetAllCustomersTest() throws Exception {
        long count = customerRepository.count();

        if (count != 3) {
            throw new AssertionError("Oczekiwano 3 rekordów w bazie danych, ale znaleziono: " + count);
        }
        this.mockMvc
                .perform(get("/api/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)));
    }



    @Test
    public void shouldUpdateCustomerTest() throws Exception {
        Customer customer = customerRepository.findById(TEST_ID).orElseThrow();
        assertEquals(customer.getFirstName(),"Jacek");
        CustomerDTO requestBody= customerService.getCustomerById(TEST_ID);
        requestBody.setFirstName("Jan");
        requestBody.setLastName("Pozowski");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/customers/{id}",TEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Jan"))
                .andExpect(jsonPath("$.lastName").value("Pozowski"));

        customer=customerRepository.findById(TEST_ID).orElseThrow();
        assertEquals(customer.getFirstName(),"Jan");
    }

    @Test
    public void shouldDeleteCustomerTest() throws Exception{
        assertEquals(customerRepository.count(),3);
        this.mockMvc.perform(delete("/api/customers/{id}",TEST_ID))
                .andExpect(status().isOk());
        assertEquals(customerRepository.count(),2);
    }
    @Test
    public void shouldGetCustomerOrdersTest() throws Exception {

            long count = orderRepository.findByCustomerId(TEST_ID).size();

            if (count != 2) {
                throw new AssertionError("Oczekiwano 2 rekordów w bazie danych, ale znaleziono: " + count);
            }
            this.mockMvc
                    .perform(get("/api/customers/{id}/orders",TEST_ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));

    }
    @Test
    public void optimisticLockingTest(){
        Customer customer=customerRepository.findById("93a35482-aa55-4b5d-b53f-68a14e1f6152").orElseThrow();
        Customer customer1=customerRepository.findById("93a35482-aa55-4b5d-b53f-68a14e1f6152").orElseThrow();
        customer.setFirstName("Jan");
        customerRepository.save(customer);
        customer1.setFirstName("Mateusz");

        assertThrows(ObjectOptimisticLockingFailureException.class,()->customerRepository.save(customer1));
    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }


}
