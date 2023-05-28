package pl.com.gymtech.courierspring.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.api.OrdersApiDelegate;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.service.OrderService;

import java.util.List;

@Service
public class OrderDelegateImpl implements OrdersApiDelegate {

    OrderService orderService;

    public OrderDelegateImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @Override
    public ResponseEntity<Void> deleteOrderById(String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @Override
    public ResponseEntity<TrackingDTO> getOrderTracking(String orderId) {
        return ResponseEntity.ok(orderService.getOrderTracking(orderId));
    }

    @Override
    public ResponseEntity<OrderDTO> updateOrderById(String id, OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id,orderDTO));
    }

    @Override
    public ResponseEntity<TrackingDTO> updateOrderTracking(String orderId,TrackingDTO trackingDTO) {
        return ResponseEntity.ok(orderService.updateOrderTracking(orderId, trackingDTO));
    }
}
