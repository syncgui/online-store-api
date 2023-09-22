package github.syncgui.onlinestoreapi.controllers;

import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<ProductDto> findingAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ProductDto findingById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ProductDto create(@Valid @RequestBody ProductDto product) {
        return service.create(product);
    }

    @PutMapping
    public ProductDto update(@Valid @RequestBody ProductDto product) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
