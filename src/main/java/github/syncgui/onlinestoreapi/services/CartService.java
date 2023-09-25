package github.syncgui.onlinestoreapi.services;

import github.syncgui.onlinestoreapi.dtos.CartDto;
import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.models.Cart;
import github.syncgui.onlinestoreapi.models.Product;
import github.syncgui.onlinestoreapi.models.User;
import github.syncgui.onlinestoreapi.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static github.syncgui.onlinestoreapi.mappers.Mapper.parseListObject;
import static github.syncgui.onlinestoreapi.mappers.Mapper.parseObject;


@Service
public class CartService {

    @Autowired
    CartRepository repository;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    public List<CartDto> findAll() {
        return parseListObject(repository.findAll(), CartDto.class);
    }

    public CartDto findById(Long id) {
        Cart result = repository.findById(id).orElseThrow(RuntimeException::new);
        return parseObject(result, CartDto.class);
    }

    public CartDto create(Long id, List<ProductDto> productsDto) {
        User user = parseObject(userService.findById(id), User.class);

        Double totalAmount = 0.0;

        for (ProductDto product : productsDto) { totalAmount += product.getPrice(); }

        List<Product> products = parseListObject(productsDto, Product.class);

        for (Product product : products) { productService.findById(product.getId()); }

        return parseObject(repository.save(new Cart(user, products, totalAmount)), CartDto.class);
    }
}
