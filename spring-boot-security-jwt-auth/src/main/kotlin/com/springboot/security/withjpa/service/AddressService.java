package com.springboot.security.withjpa.service;

import com.springboot.security.withjpa.model.Address;
import com.springboot.security.withjpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Service
public class AddressService {

    private AddressRepository repository;

    @Autowired
    public void setRepository(AddressRepository repository){
        this.repository = repository;
    }


    public List<Address> getAllAddress() {
        return this.repository.findAll();
    }

    public Address getAddressById(Integer id) {
        return this.repository.findById(id).orElse(new Address(id,"Not","Found","please","try Again"));
    }

    public Address addAddress(Address address) {
        return this.repository.save(address);
    }

    public Address updateAddress(Address address) {
        Optional<Address> addressExist = this.repository.findById(address.getId());
        if (addressExist.isPresent()){
            addressExist.get().setCity(address.getCity());
            addressExist.get().setState(address.getState());
            addressExist.get().setCity(address.getCity());
            addressExist.get().setMobile(address.getMobile());
            return this.repository.save(addressExist.get());
        }else
            return null;
    }

    public void deleteAddress(Integer id) {

        this.repository.findById(id).ifPresentOrElse(
                this.repository::delete,null);
    }
}
