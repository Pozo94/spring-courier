package pl.com.gymtech.courierspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.Driver;

import java.util.List;
import java.util.Optional;
@Repository
public interface DriverRepository extends CrudRepository<Driver,String> {
    Driver save(Driver driver);
    List<Driver> findAll();
    Optional<Driver> findById(String  id);
}
