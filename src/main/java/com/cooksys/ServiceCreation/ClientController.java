package com.cooksys.ServiceCreation;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

	private ClientService service;
	
	ClientController(ClientService service){
		this.service = service;
	}
	
	@GetMapping()
	public List<ClientDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public ClientDto get(@PathVariable Long id) {
		return service.get(id);
	}
	
	@GetMapping("{id}/address")
	public AddressDto getClientAddress(@PathVariable Long id){
		return service.getClientAddress(id);
	}
	
	@GetMapping("{id}/relations")
	public List<ClientDto> getClientRelations(@PathVariable Long id){
		return service.getRelations(id);
	}
	
	@PostMapping
	public Long post(@RequestBody @Validated ClientDto clientDto) {
		return service.post(clientDto);
	}
	
	@PostMapping("{id}/relations/{relationid}")
	public Long addRelation(@PathVariable Long id, @PathVariable Long relationid) {
		return service.addRelation(id, relationid);
	}
	
	@PutMapping("{id}")
	public Long put(@PathVariable Long id, @RequestBody @Validated ClientDto clientDto) {
		return service.put(id, clientDto);
	}
	
	@PostMapping("{id}/address/{addressid}")
	public Long setClientAddress(@PathVariable Long id, @PathVariable Long addressid) {
		return service.setClientAddress(id, addressid);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
