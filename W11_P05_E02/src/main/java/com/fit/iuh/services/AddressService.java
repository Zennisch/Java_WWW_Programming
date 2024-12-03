package com.fit.iuh.services;

import com.fit.iuh.entities.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    List<Address> findAll();

    Address findById(int id);
}
