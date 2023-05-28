package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.Customer;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,String> {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(String id);
}
