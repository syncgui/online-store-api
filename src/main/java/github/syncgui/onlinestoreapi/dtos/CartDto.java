package github.syncgui.onlinestoreapi.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

public class CartDto {

    private UserDto user;

    private List<ProductDto> products;

    @Min(0)
    private Double totalAmount;

    public CartDto() {
    }

    public CartDto(UserDto user, List<ProductDto> products, Double totalAmount) {
        this.user = user;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return Objects.equals(user, cartDto.user) && Objects.equals(products, cartDto.products) && Objects.equals(totalAmount, cartDto.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, products, totalAmount);
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "user=" + user +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
