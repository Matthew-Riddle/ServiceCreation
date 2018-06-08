package com.cooksys.ServiceCreation;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface AddressMapper {

	AddressDto toDto(Address adress);
	
	Address fromDto(AddressDto dto);
	
}
