package github.syncgui.onlinestoreapi.services;

import github.syncgui.onlinestoreapi.dtos.UserDto;
import github.syncgui.onlinestoreapi.mappers.UserMapper;
import github.syncgui.onlinestoreapi.models.User;
import github.syncgui.onlinestoreapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static github.syncgui.onlinestoreapi.mappers.UserMapper.toDto;
import static github.syncgui.onlinestoreapi.mappers.UserMapper.toModel;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserDto> findAll()  {
        return repository.findAll().stream().map(UserMapper::toDto).toList();
    }

    public UserDto findById(Long id) {
        Optional<User> result = repository.findById(id);

        return toDto(result.orElseThrow(RuntimeException::new));
    }

    public UserDto create(UserDto user) {
        if (user == null) throw new RuntimeException();

        return toDto(repository.save(toModel(user)));
    }

    public UserDto update(UserDto user) {
        if (user == null) throw new RuntimeException();

        User entity = repository.findById(user.getId()).orElseThrow(RuntimeException::new);

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());

        return toDto(repository.save(entity));
    }

    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(RuntimeException::new);

        repository.delete(user);
    }

    String string = "oi";

}
