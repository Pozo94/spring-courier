package pl.com.gymtech.courierspring.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.api.OrdersApiDelegate;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.service.OrderService;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<Void> deleteOrderById(UUID id) {
        orderService.deleteOrder(id.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(UUID id) {
        return ResponseEntity.ok(orderService.getOrderById(id.toString()));
    }

    @Override
    public ResponseEntity<TrackingDTO> getOrderTracking(UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderTracking(orderId.toString()));
    }

    @Override
    public ResponseEntity<OrderDTO> updateOrderById(UUID id, OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id.toString(),orderDTO));
    }

    @Override
    public ResponseEntity<TrackingDTO> updateOrderTracking(UUID orderId,TrackingDTO trackingDTO) {
        return ResponseEntity.ok(orderService.updateOrderTracking(orderId.toString(), trackingDTO));
    }
}
