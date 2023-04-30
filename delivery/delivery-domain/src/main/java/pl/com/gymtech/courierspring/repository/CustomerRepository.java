package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
}
