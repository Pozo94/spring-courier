package pl.com.gymtech.courierspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import pl.com.gymtech.courierspring.api.DriversApiController;
import pl.com.gymtech.courierspring.dto.DriverDTO;
import pl.com.gymtech.courierspring.entity.Driver;
import pl.com.gymtech.courierspring.repository.DriverRepository;
import pl.com.gymtech.courierspring.service.DriverService;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@SqlGroup(@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = { "classpath:/drop_schema.sql", "classpath:/create_schema.sql","classpath:/insertDriver_schema.sql"})
)
public class DriverTest {
    private MockMvc mockMvc;
    @Autowired
    private DriversApiController driversApiController;
    @Autowired private DriverService driverService;
    @Autowired private DriverRepository driverRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private static final String TEST_ID="93a35482-aa55-4b5d-b53f-68a14e1f6152";

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void shouldAddDriverTest() throws Exception {
        assertEquals(driverRepository.count(),3);

        DriverDTO requestBody = new DriverDTO();
        requestBody.setFirstName("Antoni");
        requestBody.setLastName("Sobieski");
        requestBody.setEmail("sobieski@poczta.fm");
        requestBody.setPhone("876654567");

        mockMvc.perform(post("/api/drivers/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk());

        assertEquals(driverRepository.count(),4);

    }
    @Test
    public void shouldGetDriverTest() throws Exception {
        Driver driver=driverRepository.findById(TEST_ID).orElseThrow();
        assertEquals(driver.getFirstName(),"Jan");
        assertEquals(driver.getLastName(),"Michalik");
        this.mockMvc
                .perform(get("/api/drivers/{id}", TEST_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.firstName").value("Jan"))
                .andExpect(jsonPath("$.lastName").value("Michalik"));

    }
    @Test
    public void shouldGetAllDriversTest() throws Exception {
        assertEquals(driverRepository.count(),3);
        this.mockMvc
                .perform(get("/api/drivers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)));
    }



    @Test
    public void shouldUpdateDriverTest() throws Exception {
        Driver driver=driverRepository.findById(TEST_ID).orElseThrow();
        assertEquals(driver.getFirstName(),"Jan");

        DriverDTO requestBody= driverService.getDriverById(TEST_ID);
        requestBody.setFirstName("Janusz");
        requestBody.setLastName("Kowalski");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/drivers/{id}",TEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Janusz"))
                .andExpect(jsonPath("$.lastName").value("Kowalski"));

        driver=driverRepository.findById(TEST_ID).orElseThrow();
        assertEquals(driver.getFirstName(),"Janusz");
    }
    @Test
    public void shouldDeleteDriverTest() throws Exception{
        assertEquals(driverRepository.count(),3);

        this.mockMvc.perform(delete("/api/drivers/{id}",TEST_ID))
                .andExpect(status().isOk());

        assertEquals(driverRepository.count(),2);

    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
