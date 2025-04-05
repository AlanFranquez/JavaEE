package com.JavaEE.tallerJava.business.repositories;

import com.JavaEE.tallerJava.business.entities.Embarcacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface embarcacionRepository extends JpaRepository<Embarcacion, String> {
}
