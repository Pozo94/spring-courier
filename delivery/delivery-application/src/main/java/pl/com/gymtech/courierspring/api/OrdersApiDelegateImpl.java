package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.OrderDomain;
import pl.com.gymtech.courierspring.entity.ShipmentDomain;
import pl.com.gymtech.courierspring.model.Order;
import pl.com.gymtech.courierspring.service.OrderService;
import pl.com.gymtech.courierspring.service.ShipmentService;

import java.util.List;

@Service
public class OrdersApiDelegateImpl implements OrdersApiDelegate {
    private OrderService orderService;
    private ShipmentService shipmentService;

    public OrdersApiDelegateImpl(OrderService orderService,ShipmentService shipmentService) {
        this.orderService = orderService;
        this.shipmentService=shipmentService;
    }

    @Override
    public ResponseEntity<List<OrderDomain>> ordersGet() {
        List<OrderDomain> orders=orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @Override
    public ResponseEntity<Void> ordersIdDelete(Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<OrderDomain> ordersIdGet(Integer id) {
        OrderDomain order=orderService.getOrderById(id);
        return ResponseEntity.ok().body(order);
    }

    @Override
    public ResponseEntity<Void> ordersIdPut(Integer id, Order order) {
        //orderService.updateOrder(id,order);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ShipmentDomain> ordersOrderIdShipmentGet(Integer orderId) {
        ShipmentDomain shipment=shipmentService.getOrderShipmentDetails(orderId);
        return ResponseEntity.ok().body(shipment);
    }

    @Override
    public ResponseEntity<Void> ordersOrderIdShipmentPut(Integer orderId) {
        shipmentService.updateOrderShipmentDetails(orderId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> ordersPost(Order order) {
       // orderService.addOrder(order);
        return ResponseEntity.noContent().build();
    }
}
