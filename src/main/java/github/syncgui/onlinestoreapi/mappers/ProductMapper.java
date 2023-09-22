package github.syncgui.onlinestoreapi.mappers;

import github.syncgui.onlinestoreapi.dtos.ProductDto;
import github.syncgui.onlinestoreapi.models.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static Product toModel(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
