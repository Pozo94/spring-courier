package pl.com.gymtech.courierspring.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.model.Customer;
import pl.com.gymtech.courierspring.service.CustomerService;

import java.util.List;

@Service
public class CustomersApiDelegateImpl implements CustomersApiDelegate {
    private CustomerService customerService;

    public CustomersApiDelegateImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<CustomerDomain>> customersGet() {
        List<CustomerDomain> customers= customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @Override
    public ResponseEntity<Void> customersIdDelete(Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> customersIdGet(Long id) {
        return CustomersApiDelegate.super.customersIdGet(id);
    }

    @Override
    public ResponseEntity<CustomerDomain> customersIdOrdersGet(Integer id) {

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @Override
    public ResponseEntity<Void> customersIdPut(Long id, Customer customer) {
        customerService.updateCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> customersPost(Customer customer) {
        return CustomersApiDelegate.super.customersPost(customer);
    }
}
