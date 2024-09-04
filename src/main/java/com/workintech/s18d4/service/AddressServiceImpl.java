package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AddressRepository;
import com.workintech.s18d4.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address addressDetails) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        existingAddress.setStreet(addressDetails.getStreet());
        existingAddress.setNo(addressDetails.getNo());
        existingAddress.setCity(addressDetails.getCity());
        existingAddress.setCountry(addressDetails.getCountry());
        existingAddress.setDescription(addressDetails.getDescription());

        return addressRepository.save(existingAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
