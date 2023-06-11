package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.Order;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends CrudRepository<Order,String> {
    Order save(Order order);
    Order saveAndFlush(Order order);
    List<Order> findAll();
    Optional<Order> findById(String id);
    List<Order> findByCustomerId(String id);

    Order findFirstByStatus(String status);
}
