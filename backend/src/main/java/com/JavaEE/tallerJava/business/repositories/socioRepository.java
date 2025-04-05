package com.JavaEE.tallerJava.business.repositories;

import com.JavaEE.tallerJava.business.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface socioRepository extends JpaRepository<Socio, Integer> {
}
