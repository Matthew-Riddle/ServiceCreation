package com.cooksys.ServiceCreation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByAddressEquals(Address address);
	
}
