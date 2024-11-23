package com.fit.iuh.repositories;

import com.fit.iuh.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addresses", path = "addresses", exported = false)
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
