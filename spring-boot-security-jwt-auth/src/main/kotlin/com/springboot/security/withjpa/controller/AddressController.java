package com.springboot.security.withjpa.controller;

import com.springboot.security.withjpa.model.Address;
import com.springboot.security.withjpa.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Controller
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/getAllAddress", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddress(){
        return this.addressService.getAllAddress();
    }

    @RequestMapping(value = "/getAddressById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Address getAddressById(@PathVariable Integer id){
        return this.addressService.getAddressById(id);
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public Address addAddress(@RequestBody Address address){
        return this.addressService.addAddress(address);
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.PUT)
    @ResponseBody
    public Address updateAddress(@RequestBody Address address){
        return this.addressService.updateAddress(address);
    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAddress(@RequestParam Integer id){
        this.addressService.deleteAddress(id);
    }


}
