package com.lestro.kata.controller;

import com.lestro.kata.entity.Brewery;
import com.lestro.kata.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/breweries")
public class BreweryController {

    @Autowired
    private BreweryService breweryService;

    @GetMapping
    public List<Brewery> getAllBreweries() {
        return breweryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> getBreweryById(@PathVariable Integer id) {
        Optional<Brewery> brewery = breweryService.findById(id);
        return brewery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Brewery createBrewery(@RequestBody Brewery brewery) {
        return breweryService.save(brewery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brewery> updateBrewery(@PathVariable Integer id, @RequestBody Brewery breweryDetails) {
        Optional<Brewery> brewery = breweryService.findById(id);
        if (brewery.isPresent()) {
            breweryDetails.setId(id);
            return ResponseEntity.ok(breweryService.save(breweryDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrewery(@PathVariable Integer id) {
        if (breweryService.findById(id).isPresent()) {
            breweryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}