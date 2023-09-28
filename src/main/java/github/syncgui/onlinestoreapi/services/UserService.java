package github.syncgui.onlinestoreapi.services;

import github.syncgui.onlinestoreapi.dtos.UserDto;
import github.syncgui.onlinestoreapi.exceptions.RequiredObjectIsNullException;
import github.syncgui.onlinestoreapi.exceptions.ResourceNotFoundException;
import github.syncgui.onlinestoreapi.models.User;
import github.syncgui.onlinestoreapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static github.syncgui.onlinestoreapi.mappers.Mapper.parseListObject;
import static github.syncgui.onlinestoreapi.mappers.Mapper.parseObject;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserDto> findAll()  {
        return parseListObject(repository.findAll(), UserDto.class);
    }

    public UserDto findById(Long id) {
        User result = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!"));

        return parseObject(result, UserDto.class);
    }

    public UserDto create(UserDto user) {
        if (user == null) throw new RequiredObjectIsNullException();

        User entity = parseObject(user, User.class);

        return parseObject(repository.save(entity), UserDto.class);
    }

    public UserDto update(UserDto user) {
        if (user == null) throw new RequiredObjectIsNullException();

        User entity = parseObject(repository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!")), User.class);

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());

        return parseObject(repository.save(entity), UserDto.class);
    }

    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!"));

        repository.delete(user);
    }
}
