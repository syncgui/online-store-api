package github.syncgui.onlinestoreapi.mappers;

import github.syncgui.onlinestoreapi.dtos.CartDto;
import github.syncgui.onlinestoreapi.models.Cart;

public class CartMapper {

    public static CartDto toDto(Cart cart) {
        return CartDto.builder()
                .user(cart.getUser())
                .products(cart.getProducts())
                .totalAmount(cart.getTotalAmount())
                .build();
    }

    public static Cart toModel(CartDto dto) {
        return Cart.builder()
                .user(dto.getUser())
                .products(dto.getProducts())
                .totalAmount(dto.getTotalAmount())
                .build();
    }
}
