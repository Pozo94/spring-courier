package pl.com.gymtech.courierspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.gymtech.courierspring.entity.Tracking;

import java.util.Optional;

@Repository
public interface TrackingRepository extends CrudRepository<Tracking,String> {

    Tracking save(Tracking entity);
    Optional<Tracking> findByOrderId(String s);


}
