package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.DriverDomain;
import pl.com.gymtech.courierspring.model.Driver;
import pl.com.gymtech.courierspring.model.Order;
import pl.com.gymtech.courierspring.service.DriverService;

import java.util.List;

@Service
public class DriversApiDelegateImpl implements DriversApiDelegate{

    private DriverService driverService;

    public DriversApiDelegateImpl(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public ResponseEntity<List<DriverDomain>> driversGet() {
        List<DriverDomain> drivers=driverService.getAllDrivers();

        return ResponseEntity.ok().body(drivers);
    }

    @Override
    public ResponseEntity<Void> driversIdDelete(Integer id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DriverDomain> driversIdGet(Integer id) {
        DriverDomain driver=driverService.getDriverById(id);
        return ResponseEntity.ok().body(driver);
    }

    @Override
    public ResponseEntity<Void> driversIdPut(Integer id, Driver driver) {
        //driverService.updateDriver(id,driver);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> driversPost(Driver driver) {
        //driverService.addDriver(driver);
        return ResponseEntity.noContent().build();
    }
}

