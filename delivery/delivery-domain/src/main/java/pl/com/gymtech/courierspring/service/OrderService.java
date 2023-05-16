package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.entity.OrderDomain;
import pl.com.gymtech.courierspring.entity.ShipmentDomain;
import pl.com.gymtech.courierspring.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderDomain> getAllOrders(){
        return null;
    }
    public void addOrder(OrderDomain order){}
    public OrderDomain getOrderById(Integer id){return null;}
    public void updateOrder(Integer id,OrderDomain order){}
    public void deleteOrder(Integer id){}
    public List<OrderDomain> getCustomerOrders(Integer id){return null;}

    public ShipmentDomain getOrderShipment(Integer orderId){return null;}
}
