package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.AddressDomain;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressDomain, Long> {
    AddressDomain save(AddressDomain addressDomain);
    List<AddressDomain> findAll();
    Optional<AddressDomain> findById(Long id);
}
