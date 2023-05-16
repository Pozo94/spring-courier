package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.entity.CustomerDomain;
import pl.com.gymtech.courierspring.entity.ShipmentDomain;
import pl.com.gymtech.courierspring.repository.OrderRepository;
import pl.com.gymtech.courierspring.repository.ShipmentRepository;

import java.util.List;

@Service
public class ShipmentService {
    private OrderRepository orderRepository ;
    private ShipmentRepository shipmentRepository;

    /* private List<CustomerDomain> getAllCustomers(){
        return null;
    }
    private void addCustomer(CustomerDomain customer){}
    private CustomerDomain getCustomerById(Integer id){return null;}
    private void updateCustomer(Integer id){}
    private void deleteCustomer(Integer id){}*/

    public ShipmentDomain getOrderShipmentDetails(Integer id){return null;}
    public ShipmentDomain updateOrderShipmentDetails(Integer id){return null;}
}
