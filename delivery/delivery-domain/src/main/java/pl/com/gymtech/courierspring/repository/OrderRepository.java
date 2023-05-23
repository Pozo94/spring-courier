package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.OrderDomain;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<OrderDomain,Long> {
    OrderDomain save(OrderDomain orderDomain);
    List<OrderDomain> findAll();
    Optional<OrderDomain> findById(Long id);
}
