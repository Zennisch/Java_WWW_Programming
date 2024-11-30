package com.fit.iuh.services.impl;

import com.fit.iuh.entities.Address;
import com.fit.iuh.repositories.AddressRepository;
import com.fit.iuh.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

}
