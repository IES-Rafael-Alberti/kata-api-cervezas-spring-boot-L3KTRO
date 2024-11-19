package com.lestro.kata.controller;

import com.lestro.kata.entity.Style;
import com.lestro.kata.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/styles")
public class StyleController {

    @Autowired
    private StyleService styleService;

    @GetMapping
    public List<Style> getAllStyles() {
        return styleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> getStyleById(@PathVariable Integer id) {
        Optional<Style> style = styleService.findById(id);
        return style.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Style createStyle(@RequestBody Style style) {
        return styleService.save(style);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Style> updateStyle(@PathVariable Integer id, @RequestBody Style styleDetails) {
        Optional<Style> style = styleService.findById(id);
        if (style.isPresent()) {
            styleDetails.setId(id);
            return ResponseEntity.ok(styleService.save(styleDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStyle(@PathVariable Integer id) {
        if (styleService.findById(id).isPresent()) {
            styleService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}