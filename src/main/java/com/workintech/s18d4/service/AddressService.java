package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import java.util.List;

public interface AddressService {
    List<Address> findAllAddresses();
    Address findAddressById(Long id);
    Address saveAddress(Address address);
    Address updateAddress(Long id, Address addressDetails);
    void deleteAddress(Long id);
}
