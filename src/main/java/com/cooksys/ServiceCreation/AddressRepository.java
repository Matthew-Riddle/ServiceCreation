package com.cooksys.ServiceCreation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{
List<Address> findByCity(String city);
List<Address> findByState(String state);
List<Address> findByCityAndStateEquals(String city, String state);	
	
}
