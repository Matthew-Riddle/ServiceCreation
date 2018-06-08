package com.cooksys.ServiceCreation;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ClientMapper {


	ClientDto toDto(Client client);
	
	Client fromDto(ClientDto dto);
	
}
