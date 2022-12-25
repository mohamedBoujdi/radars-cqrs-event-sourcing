package com.boujdi.immatriculationservice.queries.repositories;

import com.boujdi.immatriculationservice.queries.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
