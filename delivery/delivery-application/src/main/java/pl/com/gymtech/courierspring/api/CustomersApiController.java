package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.model.Customer;

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T10:08:20.752442600+02:00[Europe/Warsaw]")
@RestController
@RequestMapping("${openapi.courier.base-path:}")
public class CustomersApiController implements CustomersApi {

    private final CustomersApiDelegate delegate;

    public CustomersApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) CustomersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CustomersApiDelegate() {});
    }

    @Override
    public CustomersApiDelegate getDelegate() {
        return delegate;
    }

    @Override
    public ResponseEntity<List<CustomerDomain>> customersGet() {
        return CustomersApi.super.customersGet();
    }

    @Override
    public ResponseEntity<Void> customersIdDelete(Long id) {
        return CustomersApi.super.customersIdDelete(id);
    }

    @Override
    public ResponseEntity<Void> customersIdGet(Long id) {
        return CustomersApi.super.customersIdGet(id);
    }

    @Override
    public ResponseEntity<CustomerDomain> customersIdOrdersGet(Integer id) {
        return CustomersApi.super.customersIdOrdersGet(id);
    }

    @Override
    public ResponseEntity<Void> customersIdPut(Long id, Customer customer) {
        return CustomersApi.super.customersIdPut(id, customer);
    }

    @Override
    public ResponseEntity<Void> customersPost(Customer customer) {
        return CustomersApi.super.customersPost(customer);
    }
}
