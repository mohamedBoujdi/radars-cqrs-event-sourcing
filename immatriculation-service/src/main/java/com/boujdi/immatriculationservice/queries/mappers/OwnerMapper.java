package com.boujdi.immatriculationservice.queries.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    OwnerDTO ownerToOwnerDTO(Owner owner);
}
