package com.cooksys.ServiceCreation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

	private ClientRepository repo;
	private ClientMapper mapper;
	private AddressRepository arepo;
	private AddressMapper amapper;
	
	public ClientService(ClientRepository repo, ClientMapper mapper, AddressRepository arepo, AddressMapper amapper) {
		this.repo = repo;
		this.mapper = mapper;
		this.arepo = arepo;
		this.amapper = amapper;
	}
	
	// Controlled
	public ClientDto get(Long id) {
		return mapper.toDto(repo.getOne(id));
	}
	
	// Controlled
	public List<ClientDto> getAll() {
		return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	// Controlled
	public AddressDto getClientAddress(Long id) {
		return amapper.toDto(repo.getOne(id).getAddress());
	}
	
	// Controlled
	public List<ClientDto> getRelations(Long id) {
		return repo.getOne(id).getRelatives().stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	// Controlled
	public Long post(ClientDto clientDto) {
		clientDto.setId(null);
		return repo.save(mapper.fromDto(clientDto)).getId();
	}
	
	// Controlled
	public Long put(Long id, ClientDto clientDto) {
		clientDto.setId(id);
		return repo.save(mapper.fromDto(clientDto)).getId();
	}
	
	// Controlled
	public void delete(Long id) {
		repo.delete(repo.getOne(id));
	}
	
	/*get this later*/
	public Long addRelation(Long id, Long relid) {
		//Just add the clientdto to the list of relatives you idiot
		List<Client> relatives = repo.getOne(id).getRelatives();
		relatives.add(repo.getOne(relid));
		repo.getOne(id).setRelatives(relatives);
		
		List<Client> otherRelatives = repo.getOne(relid).getRelatives();
		otherRelatives.add(repo.getOne(id));
		repo.getOne(relid).setRelatives(otherRelatives);
		
		repo.save(repo.getOne(relid)).getId();
		return repo.save(repo.getOne(id)).getId();
		
	}
	
	public Long setClientAddress(Long id, Long address) {
		repo.getOne(id).setAddress(arepo.getOne(address));
		return repo.save(repo.getOne(id)).getId();
	}
	
	
	
	
	
}
