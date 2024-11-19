package com.lestro.kata.service;

import com.lestro.kata.entity.Brewery;
import com.lestro.kata.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreweryService {

    @Autowired
    private BreweryRepository breweryRepository;

    public List<Brewery> findAll() {
        return breweryRepository.findAll();
    }

    public Optional<Brewery> findById(Integer id) {
        return breweryRepository.findById(id);
    }

    public Brewery save(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    public void deleteById(Integer id) {
        breweryRepository.deleteById(id);
    }
}