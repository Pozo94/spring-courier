package pl.com.gymtech.courierspring.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.gymtech.courierspring.mapper.OrderMapper;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.entity.Order;
import pl.com.gymtech.courierspring.repository.CustomerRepository;
import pl.com.gymtech.courierspring.repository.OrderRepository;

import javax.persistence.LockModeType;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {
    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    OrderMapper orderMapper;
    TrackingService trackingService;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public List<OrderDTO> getCustomerOrders(String customerId){
        return  orderMapper.orderToOrderDTO(orderRepository.findByCustomerId(customerId));
    }
    public List<OrderDTO> getAllOrders(){
        return orderMapper.orderToOrderDTO(orderRepository.findAll());
    }
    public OrderDTO getOrderById(String id){
        return orderMapper.orderToOrderDTO(orderRepository.findById(id).orElseThrow(()->new NoSuchElementException("Order with id: "+id+ " not found!" )));

    }
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order=new Order(orderDTO.getSenderAddress(),orderDTO.getReceiverAddress(),orderDTO.getPackageType(),orderDTO.getPackageSize(),orderDTO.getStatus());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomerId()).orElseThrow(()->new NoSuchElementException("Customer with id: "+orderDTO.getCustomerId()+ " not found!")));
        TrackingDTO trackingDTO= new TrackingDTO();
        trackingDTO.setEventType("Przyjęto zamówienie");
        trackingDTO.setEventTime(LocalDate.now());
        trackingDTO.setLocation(order.getSenderAddress());
        trackingDTO.setDescription("Zamówienie w trakcie realizacji");

        order=orderRepository.save(order);
        trackingService.createOrderTracking(trackingDTO,order);
        return orderMapper.orderToOrderDTO(order);
    }
    @Transactional
    public void deleteOrder(String id){
        orderRepository.deleteById(id);
    }
    @Transactional
    public OrderDTO updateOrder(String id,OrderDTO orderDTO){
        Order order=orderRepository.findById(id).orElseThrow(()->new NoSuchElementException("Order with id: "+id+ " not found!" ));
        order.setPackageSize(orderDTO.getPackageSize());
        order.setDeliveryDate(orderDTO.getDeliveryDate());
        order.setPackageType(orderDTO.getPackageType());
        order.setReceiverAddress(orderDTO.getReceiverAddress());
        order.setSenderAddress(orderDTO.getSenderAddress());
        order.setStatus(orderDTO.getStatus());
        return orderMapper.orderToOrderDTO(orderRepository.save(order));

    }
    public TrackingDTO getOrderTracking(String orderId){
        return  trackingService.getTracking(orderId);
    }
    @Transactional
    public  TrackingDTO updateOrderTracking(String id,TrackingDTO trackingDTO){
        return trackingService.updateTracking(id,trackingDTO);

    }
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public OrderDTO findFirstByStatus(String status){
        return orderMapper.orderToOrderDTO(orderRepository.findFirstByStatus(status));
    }
    @Transactional
   // @Scheduled(fixedDelay = 1000) // Przykładowy interwał czasowy - 1 sekunda
    public void updateOrderStatus() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        OrderDTO order = findFirstByStatus("Delivery");

        if (order != null) {
            try {
                // Aktualizacja statusu zamowienia na "Delivered"
                order.setStatus("Delivered");

            } catch (Exception e) {
                // Obsługa wyjątku
                order.setStatus("Error");
            } finally {
                // Zapis zamowienia (aktualizacja wersji)
                updateOrder(order.getId(), order);

            }

        }
    }
}

