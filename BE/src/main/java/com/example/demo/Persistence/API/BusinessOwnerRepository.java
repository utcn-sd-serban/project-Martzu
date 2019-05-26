package com.example.demo.Persistence.API;

import com.example.demo.Model.BusinessOwner;

import java.util.List;
import java.util.Optional;

public interface BusinessOwnerRepository {

    BusinessOwner save(BusinessOwner businessOwner);

    Optional<BusinessOwner> findById(int id);

    Optional<BusinessOwner> findByUsername(String username);

    List<BusinessOwner> findAll();

}
