package pl.com.gymtech.courierspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.gymtech.courierspring.api.AddressesApi;
import pl.com.gymtech.courierspring.api.AddressesApiDelegate;
import pl.com.gymtech.courierspring.entity.AddressDomain;
import pl.com.gymtech.courierspring.model.Address;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/address")
public class AddressesApiController implements AddressesApi {

    private final AddressesApiDelegate delegate;
    @Autowired
    public AddressesApiController( AddressesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AddressesApiDelegate() {});
    }

    @Override
    public AddressesApiDelegate getDelegate() {
        return delegate;
    }

    @Override
    public ResponseEntity<List<AddressDomain>> addressesGet() {
        return AddressesApi.super.addressesGet();
    }

    @Override
    public ResponseEntity<Void> addressesIdDelete(Long id) {
        return AddressesApi.super.addressesIdDelete(id);
    }

    @Override
    public ResponseEntity<AddressDomain> addressesIdGet(Long id) {
        return AddressesApi.super.addressesIdGet(id);
    }

    @Override
    public ResponseEntity<Void> addressesIdPut(Long id, Address address) {
        return AddressesApi.super.addressesIdPut(id, address);
    }

    @Override
    public ResponseEntity<Void> addressesPost(Address address) {
        return AddressesApi.super.addressesPost(address);
    }
}
