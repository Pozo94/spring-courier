package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.gymtech.courierspring.entity.OrderDomain;
import pl.com.gymtech.courierspring.entity.ShipmentDomain;
import pl.com.gymtech.courierspring.model.Order;

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
@RestController
@RequestMapping("${openapi.courier.base-path:}")
public class OrdersApiController implements OrdersApi {

    private final OrdersApiDelegate delegate;

    public OrdersApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) OrdersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new OrdersApiDelegate() {});
    }

    @Override
    public OrdersApiDelegate getDelegate() {
        return delegate;
    }

    @Override
    public ResponseEntity<List<OrderDomain>> ordersGet() {
        return OrdersApi.super.ordersGet();
    }

    @Override
    public ResponseEntity<Void> ordersIdDelete(Integer id) {
        return OrdersApi.super.ordersIdDelete(id);
    }

    @Override
    public ResponseEntity<OrderDomain> ordersIdGet(Integer id) {
        return OrdersApi.super.ordersIdGet(id);
    }

    @Override
    public ResponseEntity<Void> ordersIdPut(Integer id, Order order) {
        return OrdersApi.super.ordersIdPut(id, order);
    }

    @Override
    public ResponseEntity<ShipmentDomain> ordersOrderIdShipmentGet(Integer orderId) {
        return OrdersApi.super.ordersOrderIdShipmentGet(orderId);
    }

    @Override
    public ResponseEntity<Void> ordersOrderIdShipmentPut(Integer orderId) {
        return OrdersApi.super.ordersOrderIdShipmentPut(orderId);
    }

    @Override
    public ResponseEntity<Void> ordersPost(Order order) {
        return OrdersApi.super.ordersPost(order);
    }
}
