package com.lestro.kata.service;

import com.lestro.kata.entity.Style;
import com.lestro.kata.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StyleService {

    @Autowired
    private StyleRepository styleRepository;

    public List<Style> findAll() {
        return styleRepository.findAll();
    }

    public Optional<Style> findById(Integer id) {
        return styleRepository.findById(id);
    }

    public Style save(Style style) {
        return styleRepository.save(style);
    }

    public void deleteById(Integer id) {
        styleRepository.deleteById(id);
    }
}