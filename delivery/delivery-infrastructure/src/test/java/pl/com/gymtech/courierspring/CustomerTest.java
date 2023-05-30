package pl.com.gymtech.courierspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
import pl.com.gymtech.courierspring.service.CustomerService;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest

@SqlGroup(@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = { "classpath:/drop_schema.sql", "classpath:/create_schema.sql","classpath:/insertCustomer_schema.sql"})
)
public class CustomerTest {
    private MockMvc mockMvc;
    @Autowired
    private CustomersApiController customersApiController;
    @Autowired private CustomerService customerService;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void shouldAddCustomerTest() throws Exception {
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

    }
    @Test
    public void shouldGetCustomerTest() throws Exception {
        this.mockMvc
                .perform(get("/api/customers/{id}", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.firstName").value("Jacek"));

    }
    @Test
    public void shouldGetAllCustomersTest() throws Exception {
        this.mockMvc
                .perform(get("/api/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)));
    }



    @Test
    public void shouldUpdateCustomerTest() throws Exception {
        CustomerDTO requestBody= customerService.getCustomerById("1");
        requestBody.setFirstName("Jan");
        requestBody.setLastName("Pozowski");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/customers/{id}","1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Jan"))
                .andExpect(jsonPath("$.lastName").value("Pozowski"));
    }
    @Test
    public void shouldDeleteCustomerTest() throws Exception{
        this.mockMvc.perform(delete("/api/customers/{id}","1"))
                .andExpect(status().isOk());
    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }


}
