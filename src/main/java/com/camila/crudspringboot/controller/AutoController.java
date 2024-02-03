package com.camila.crudspringboot.controller;


import com.camila.crudspringboot.domain.Auto;
import com.camila.crudspringboot.dto.AutoDTO;
import com.camila.crudspringboot.repository.AutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private AutoRepository autoRepository;

    @GetMapping
    public ResponseEntity searchAllAuto() {
        var allAuto = autoRepository.findAllByActiveTrue();
        return ResponseEntity.ok(allAuto);
    }

    @PostMapping
    public ResponseEntity createAuto(@RequestBody @Valid AutoDTO autoDTO) {
        Auto newAuto = new Auto(autoDTO);
        newAuto = autoRepository.save(newAuto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateAuto(@RequestBody @Valid AutoDTO autoDTO) {
        Optional<Auto> optionalAuto = autoRepository.findById(autoDTO.id());

        if (optionalAuto.isPresent()) {
            Auto updatingAuto = optionalAuto.get();
            updatingAuto.setBrand(autoDTO.brand());
            updatingAuto.setModel(autoDTO.model());
            updatingAuto.setPrice_in_cents(autoDTO.price_in_cents());
            return ResponseEntity.ok(updatingAuto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteAuto(@PathVariable String id ) {
        Optional<Auto> optionalAuto = autoRepository.findById(id);
        if(optionalAuto.isPresent()) {
            Auto deletingAuto = optionalAuto.get();
            deletingAuto.setActive(false);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}
