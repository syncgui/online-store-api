package github.syncgui.onlinestoreapi.services;

import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.mappers.ProductMapper;
import github.syncgui.onlinestoreapi.models.Product;
import github.syncgui.onlinestoreapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static github.syncgui.onlinestoreapi.mappers.ProductMapper.toDto;
import static github.syncgui.onlinestoreapi.mappers.ProductMapper.toModel;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(ProductMapper::toDto).toList();
    }

    public ProductDto findById(Long id) {
        Optional<Product> result = repository.findById(id);

        return toDto(result.orElseThrow(RuntimeException::new));
    }

    public ProductDto create(ProductDto product) {
        if (product == null) throw new RuntimeException();

        return toDto(repository.save(toModel(product)));
    }

    public ProductDto update(ProductDto product) {

        if (product == null) throw new RuntimeException();

        Product entity = repository.findById(product.getId()).orElseThrow(RuntimeException::new);

        entity.setName(product.getName());
        entity.setPrice(product.getPrice());

        return toDto(repository.save(entity));
    }

    public void delete(Long id) {

        Product product = repository.findById(id).orElseThrow(RuntimeException::new);

        repository.delete(product);
    }

}
