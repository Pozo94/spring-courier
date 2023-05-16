package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.CustomerDomain;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerDomain,Long> {
    CustomerDomain save(CustomerDomain customerDomain);
    List<CustomerDomain> findAll();
    Optional<CustomerDomain> findById(Long id);
}
