package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.gymtech.courierspring.entity.DriverDomain;
import pl.com.gymtech.courierspring.model.Driver;

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
@RestController
@RequestMapping("${openapi.courier.base-path:}")
public class DriversApiController implements DriversApi {

    private final DriversApiDelegate delegate;

    public DriversApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) DriversApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DriversApiDelegate() {});
    }

    @Override
    public DriversApiDelegate getDelegate() {
        return delegate;
    }

    @Override
    public ResponseEntity<List<DriverDomain>> driversGet() {
        return DriversApi.super.driversGet();
    }

    @Override
    public ResponseEntity<Void> driversIdDelete(Integer id) {
        return DriversApi.super.driversIdDelete(id);
    }

    @Override
    public ResponseEntity<DriverDomain> driversIdGet(Integer id) {
        return DriversApi.super.driversIdGet(id);
    }

    @Override
    public ResponseEntity<Void> driversIdPut(Integer id, Driver driver) {
        return DriversApi.super.driversIdPut(id, driver);
    }

    @Override
    public ResponseEntity<Void> driversPost(Driver driver) {
        return DriversApi.super.driversPost(driver);
    }
}
