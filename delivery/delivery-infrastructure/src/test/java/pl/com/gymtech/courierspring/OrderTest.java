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
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import pl.com.gymtech.courierspring.entity.Customer;
import pl.com.gymtech.courierspring.entity.Order;
import pl.com.gymtech.courierspring.entity.Tracking;
import pl.com.gymtech.courierspring.repository.OrderRepository;
import pl.com.gymtech.courierspring.repository.TrackingRepository;
import pl.com.gymtech.courierspring.service.CustomerService;
import pl.com.gymtech.courierspring.service.OrderService;
import pl.com.gymtech.courierspring.service.TrackingService;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
    @Autowired private OrderRepository orderRepository;
    @Autowired private TrackingService trackingService;
    @Autowired private TrackingRepository trackingRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private static final String TEST_ID="93a35482-aa55-4b5d-b53f-68a14e1f6152";

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void shouldAddOrderTest() throws Exception {
        assertEquals(orderRepository.count(),6);
        OrderDTO requestBody=new OrderDTO();
        requestBody.setCustomerId(TEST_ID);


        mockMvc.perform(post("/api/orders/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk());
        assertEquals(orderRepository.count(),7);



    }
    @Test
    public void shouldGetOrderTest() throws Exception {
        Order order = orderRepository.findById(TEST_ID).orElseThrow();
        assertEquals(order.getSenderAddress(),"Warszawa");
        this.mockMvc
                .perform(get("/api/orders/{id}", TEST_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(jsonPath("$.packageSize").value("Small"))
                .andExpect(jsonPath("$.packageType").value("Box"))
                .andExpect(jsonPath("$.customerId").value(TEST_ID));


    }
    @Test
    public void shouldGetAllOrdersTest() throws Exception {
        assertEquals(orderRepository.count(),6);
        this.mockMvc
                .perform(get("/api/orders"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(6)));
    }



    @Test
    public void shouldUpdateOrder() throws Exception {
        Order order= orderRepository.findById(TEST_ID).orElseThrow();
        assertEquals(order.getPackageSize(),"Small");
        OrderDTO requestBody= orderService.getOrderById(TEST_ID);
        requestBody.setPackageSize("Large");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/orders/{id}",TEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(jsonPath("$.packageSize").value("Large"))
                .andExpect(jsonPath("$.packageType").value("Box"))
                .andExpect(jsonPath("$.customerId").value(TEST_ID));
        order=orderRepository.findById(TEST_ID).orElseThrow();
        assertEquals(order.getPackageSize(),"Large");

    }
    @Test
    public void shouldDeleteOrderTest() throws Exception{
        assertEquals(orderRepository.count(),6);
        this.mockMvc.perform(delete("/api/orders/{id}",TEST_ID))
                .andExpect(status().isOk());
        assertEquals(orderRepository.count(),5);
    }
    @Test
    public void shouldGetOrderTrackingTest() throws Exception {
        assertTrue(trackingRepository.findByOrderId(TEST_ID).isPresent());
        this.mockMvc
                .perform(get("/api/orders/{id}/tracking", TEST_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(jsonPath("$.orderId").value(TEST_ID))
                .andExpect(jsonPath("$.eventType").value("Wysyłka"))
                .andExpect(jsonPath("$.location").value("Kraków"));
    }
    @Test
    public void shouldUpdateOrderTrackingTest() throws Exception {
        Tracking tracking=trackingRepository.findByOrderId(TEST_ID).orElseThrow();
        assertEquals(tracking.getEventType(),"Wysyłka");
        TrackingDTO requestBody= trackingService.getTracking(TEST_ID);
        requestBody.setEventType("Dostarczono");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/orders/{id}/tracking",TEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.eventType").value("Dostarczono"));

        tracking=trackingRepository.findByOrderId(TEST_ID).orElseThrow();
        assertEquals(tracking.getEventType(),"Dostarczono");
    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(obj);
    }
}
