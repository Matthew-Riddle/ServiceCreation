package com.cooksys.ServiceCreation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AddressService {

	private AddressRepository repo;
	private AddressMapper mapper;
	private ClientRepository crepo;
	private ClientMapper cmapper;
	
	public AddressService(AddressRepository repo, AddressMapper mapper, ClientRepository crepo, ClientMapper cmapper) {
		this.repo = repo;
		this.mapper = mapper;
		this.crepo = crepo;
		this.cmapper = cmapper;
	}
	
	public AddressDto get(Long id) {
		return mapper.toDto(repo.getOne(id));
	}
	
//	public List<AddressDto> getAll(Long id) {
//		return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
//	}
	
	public List<AddressDto> getAddress(String city, String state) {
		if(city == null && state == null) {
			return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
		}
		else if(city != null && state != null) {
			return repo.findByCityAndStateEquals(city,state).stream().map(mapper::toDto).collect(Collectors.toList());
		}
		else if(city != null){
			return repo.findByCity(city).stream().map(mapper::toDto).collect(Collectors.toList());
		}
		else {
			return repo.findByState(state).stream().map(mapper::toDto).collect(Collectors.toList());
		}
	}
	
	public List<ClientDto> getResidents(Long id) {
		
//		return crepo.findByAddressEquals(repo.getOne(id)).stream().map(cmapper::toDto).collect(Collectors.toList());
		return repo.getOne(id).getResidents().stream().map(cmapper::toDto).collect(Collectors.toList());
		
	}
	
	public Long post(AddressDto addressDto) {
		addressDto.setId(null);
		return repo.save(mapper.fromDto(addressDto)).getId();
	}
	
	public Long put(Long id, AddressDto addressDto) {
		addressDto.setId(id);
		return repo.save(mapper.fromDto(addressDto)).getId();
	}
	
	public void delete(Long id) {
		repo.delete(repo.getOne(id));
	}
	
	
	
	
	
}
