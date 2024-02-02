package com.camila.crudspringboot.controller;


import com.camila.crudspringboot.domain.Auto;
import com.camila.crudspringboot.dto.AutoDTO;
import com.camila.crudspringboot.repository.AutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity updateAuto(@RequestBody @Valid AutoDTO autoDTO) {
        Auto updatingAuto = autoRepository.getReferenceById(autoDTO.id());
        updatingAuto.setMakeBrand(autoDTO.make_brand());
        updatingAuto.setModel(autoDTO.model());
        updatingAuto.setPrice_in_cents(autoDTO.price_in_cents());
        return ResponseEntity.ok(updatingAuto);
    }

}
