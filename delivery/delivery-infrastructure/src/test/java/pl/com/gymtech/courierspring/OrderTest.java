package pl.com.gymtech.courierspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.aspectj.weaver.ast.Or;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import pl.com.gymtech.courierspring.api.OrdersApiController;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.service.CustomerService;
import pl.com.gymtech.courierspring.service.OrderService;
import pl.com.gymtech.courierspring.service.TrackingService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest

@SqlGroup(@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = { "classpath:/drop_schema.sql", "classpath:/create_schema.sql","classpath:/insertCustomer_schema.sql","classpath:/insertOrder_schema.sql","classpath:/insertTracking_schema.sql"})
)
public class OrderTest {
    private MockMvc mockMvc;
    @Autowired
    private OrdersApiController ordersApiController;
    @Autowired private OrderService orderService;
    @Autowired private TrackingService trackingService;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void shouldAddOrderTest() throws Exception {
        OrderDTO requestBody=new OrderDTO();
        requestBody.setCustomerId("3");


        mockMvc.perform(post("/api/orders/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk());



    }
    @Test
    public void shouldGetOrderTest() throws Exception {
        this.mockMvc
                .perform(get("/api/orders/{id}", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.packageSize").value("Small"))
                .andExpect(jsonPath("$.packageType").value("Box"))
                .andExpect(jsonPath("$.customerId").value("1"));


    }
    @Test
    public void shouldGetAllOrdersTest() throws Exception {
        this.mockMvc
                .perform(get("/api/orders"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(6)));
    }



    @Test
    public void shouldUpdateOrder() throws Exception {
        OrderDTO requestBody= orderService.getOrderById("1");
        requestBody.setPackageSize("Large");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/orders/{id}","1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.packageSize").value("Large"))
                .andExpect(jsonPath("$.packageType").value("Box"))
                .andExpect(jsonPath("$.customerId").value("1"));

    }
    @Test
    public void shouldDeleteOrderTest() throws Exception{
        this.mockMvc.perform(delete("/api/orders/{id}","1"))
                .andExpect(status().isOk());
    }
    @Test
    public void shouldGetOrderTrackingTest() throws Exception {
        this.mockMvc
                .perform(get("/api/orders/{id}/tracking", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.orderId").value("1"))
                .andExpect(jsonPath("$.eventType").value("Wysyłka"))
                .andExpect(jsonPath("$.location").value("Kraków"));
    }
    @Test
    public void shouldUpdateOrderTrackingTest() throws Exception {
        TrackingDTO requestBody= trackingService.getTracking("1");
        requestBody.setEventType("Dostarczono");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/orders/{id}/tracking","1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.eventType").value("Dostarczono"));


    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(obj);
    }
}
