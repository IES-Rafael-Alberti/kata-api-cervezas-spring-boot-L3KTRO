package com.lestro.kata.service;

import com.lestro.kata.entity.Beer;
import com.lestro.kata.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    public Optional<Beer> findById(Integer id) {
        return beerRepository.findById(id);
    }

    public Beer save(Beer beer) {
        return beerRepository.save(beer);
    }

    public void deleteById(Integer id) {
        beerRepository.deleteById(id);
    }
}