package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.entity.DriverDomain;
import pl.com.gymtech.courierspring.repository.DriverRepository;

import java.util.List;

@Service
public class DriverService {
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    public List<DriverDomain> getAllDrivers(){
        return null;
    }
    public void addDriver(DriverDomain driver){}
    public DriverDomain getDriverById(Integer id){return null;}
    public void updateDriver(Integer id){}
    public void deleteDriver(Integer id){}
}
