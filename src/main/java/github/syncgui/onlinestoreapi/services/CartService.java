package github.syncgui.onlinestoreapi.services;

import github.syncgui.onlinestoreapi.dtos.CartDto;
import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.exceptions.ResourceNotFoundException;
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
        Cart result = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found for this ID!"));
        return parseObject(result, CartDto.class);
    }

    public CartDto create(Long id, List<ProductDto> productsDto) {
        User user = parseObject(userService.findById(id), User.class);

        Double totalAmount = cartAmount(productsDto);

        List<Product> products = parseListObject(productsDto, Product.class);
        checkIfProductsExists(products);

        return parseObject(repository.save(new Cart(user, products, totalAmount)), CartDto.class);
    }

    public CartDto update(Long id, List<ProductDto> productsDto) {
        Cart cart = parseObject(findById(id), Cart.class);

        List<Product> products = parseListObject(productsDto, Product.class);
        checkIfProductsExists(products);

        Double totalAmount = cartAmount(productsDto);

        return parseObject(repository.save(new Cart(cart.getUser(), products, totalAmount)), CartDto.class);
    }

    private static Double cartAmount(List<ProductDto> productsDto) {
        Double totalAmount = 0.0;

        for (ProductDto product : productsDto) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    private void checkIfProductsExists(List<Product> products) {
        for (Product product : products) {
            productService.findById(product.getId());
        }
    }
}
