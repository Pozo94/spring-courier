package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Long id);
}
