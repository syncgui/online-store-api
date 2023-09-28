package github.syncgui.onlinestoreapi.controllers;

import github.syncgui.onlinestoreapi.dtos.CartDto;
import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping(value = "/{id}")
    public CartDto addCart(@PathVariable(value = "id") Long id, @RequestBody List<ProductDto> products) {
        return service.create(id, products);
    }

}
