package com.camila.crudspringboot.repository;

import com.camila.crudspringboot.domain.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, String> {
}
