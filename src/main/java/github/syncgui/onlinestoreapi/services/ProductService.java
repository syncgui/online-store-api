package github.syncgui.onlinestoreapi.services;

import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.exceptions.RequiredObjectIsNullException;
import github.syncgui.onlinestoreapi.exceptions.ResourceNotFoundException;
import github.syncgui.onlinestoreapi.models.Product;
import github.syncgui.onlinestoreapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static github.syncgui.onlinestoreapi.mappers.Mapper.parseListObject;
import static github.syncgui.onlinestoreapi.mappers.Mapper.parseObject;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductDto> findAll() {
        return parseListObject(repository.findAll(), ProductDto.class);
    }

    public ProductDto findById(Long id) {
        Product result = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!"));

        return parseObject(result, ProductDto.class);
    }

    public ProductDto create(ProductDto product) {
        if (product == null) throw new RequiredObjectIsNullException();

        Product entity = parseObject(product, Product.class);

        return parseObject(repository.save(entity), ProductDto.class);
    }

    public ProductDto update(ProductDto product) {
        if (product == null) throw new RequiredObjectIsNullException();

        Product entity = parseObject(repository.findById(product.getId()).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!")), Product.class);

        entity.setName(product.getName());
        entity.setPrice(product.getPrice());

        return parseObject(repository.save(entity), ProductDto.class);
    }

    public void delete(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!"));
        repository.delete(product);
    }
}
