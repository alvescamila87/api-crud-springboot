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
        var allAuto = autoRepository.findAll();
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
            Auto auto = optionalAuto.get();
            auto.setBrand(autoDTO.brand());
            auto.setModel(autoDTO.model());
            auto.setPrice_in_cents(autoDTO.price_in_cents());
            return ResponseEntity.ok(auto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuto(@PathVariable String id ) {
        autoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
