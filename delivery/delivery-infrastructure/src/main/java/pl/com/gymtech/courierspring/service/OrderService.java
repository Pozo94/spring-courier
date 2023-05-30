package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.Mapper.OrderMapper;
import pl.com.gymtech.courierspring.delegate.OrderDelegateImpl;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.entity.Order;
import pl.com.gymtech.courierspring.repository.CustomerRepository;
import pl.com.gymtech.courierspring.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    OrderMapper orderMapper;
    TrackingService trackingService;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, OrderMapper orderMapper, TrackingService trackingService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
        this.trackingService = trackingService;
    }

    public List<OrderDTO> getCustomerOrders(String customerId){
        return  orderMapper.orderToOrderDTO(orderRepository.findByCustomerId(customerId));
    }
    public List<OrderDTO> getAllOrders(){
        return orderMapper.orderToOrderDTO(orderRepository.findAll());
    }
    public OrderDTO getOrderById(String id){
        return orderMapper.orderToOrderDTO(orderRepository.findById(id).orElseThrow());

    }
    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order=new Order(orderDTO.getSenderAddress(),orderDTO.getReceiverAddress(),orderDTO.getPackageType(),orderDTO.getPackageSize(),orderDTO.getStatus());
        order.setCustomer(customerRepository.findById(orderDTO.getCustomerId()).orElseThrow());
        return orderMapper.orderToOrderDTO(orderRepository.save(order));
    }
    public void deleteOrder(String id){
        orderRepository.deleteById(id);
    }
    public OrderDTO updateOrder(String id,OrderDTO orderDTO){
        Order order=orderRepository.findById(id).orElseThrow();
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
    public  TrackingDTO updateOrderTracking(String id,TrackingDTO trackingDTO){
        return trackingService.updateTracking(id,trackingDTO);
    }
}

