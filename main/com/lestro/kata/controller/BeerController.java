package com.lestro.kata.controller;

import com.lestro.kata.entity.Beer;
import com.lestro.kata.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beers")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping
    public List<Beer> getAllBeers() {
        return beerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable Integer id) {
        Optional<Beer> beer = beerService.findById(id);
        return beer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Beer createBeer(@RequestBody Beer beer) {
        return beerService.save(beer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beer> updateBeer(@PathVariable Integer id, @RequestBody Beer beerDetails) {
        Optional<Beer> beer = beerService.findById(id);
        if (beer.isPresent()) {
            beerDetails.setId(id);
            return ResponseEntity.ok(beerService.save(beerDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeer(@PathVariable Integer id) {
        if (beerService.findById(id).isPresent()) {
            beerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}