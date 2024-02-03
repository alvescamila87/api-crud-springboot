package com.camila.crudspringboot.repository;

import com.camila.crudspringboot.domain.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, String> {

    List<Auto> findAllByActiveTrue();
}
