package github.syncgui.onlinestoreapi.controllers;

import github.syncgui.onlinestoreapi.dtos.UserDto;
import github.syncgui.onlinestoreapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService service;

    @GetMapping
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return service.findById(id);
    }


    @PostMapping
    public UserDto create(@Valid @RequestBody UserDto user) {
        return service.create(user);
    }

    @PutMapping
    public UserDto update(@Valid @RequestBody UserDto user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
