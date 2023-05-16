package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.OrderDomain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderDomain,Long> {
    OrderDomain save(OrderDomain orderDomain);
    List<OrderDomain> findAll();
    Optional<OrderDomain> findById(Long id);
}
