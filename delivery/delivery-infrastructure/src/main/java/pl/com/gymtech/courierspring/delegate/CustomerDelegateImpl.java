package pl.com.gymtech.courierspring.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.api.CustomersApiDelegate;
import pl.com.gymtech.courierspring.dto.CustomerDTO;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.service.CustomerService;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerDelegateImpl implements CustomersApiDelegate {
    CustomerService customerService;

    public CustomerDelegateImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<Void> deleteCustomerById(UUID id) {
         customerService.deleteCustomer(id.toString());
         return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(UUID  id) {
        return ResponseEntity.ok(customerService.getCustomerById(id.toString()));
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getCustomerOrders(UUID id) {
        return ResponseEntity.ok(customerService.getCustomerOrders(id.toString()));
    }

    @Override
    public ResponseEntity<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomerById(UUID id, CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id.toString(),customerDTO));
    }
}
