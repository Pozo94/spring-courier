package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.AddressDomain;
import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.repository.AddressRepository;
import pl.com.gymtech.courierspring.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<CustomerDomain> getAllCustomers(){
        return null;
    }
    public void addCustomer(CustomerDomain customer){}
    public CustomerDomain getCustomerById(Integer id){return null;}
    public void updateCustomer(Long id){}
    public void deleteCustomer(Long id){}
}
