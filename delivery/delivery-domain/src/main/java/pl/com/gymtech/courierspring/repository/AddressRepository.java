package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.gymtech.courierspring.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address save(Address address);
    List<Address> findAll();
    Optional<Address> findById(Long id);
}
