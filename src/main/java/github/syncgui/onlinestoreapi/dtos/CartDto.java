package github.syncgui.onlinestoreapi.dtos;

import github.syncgui.onlinestoreapi.models.Product;
import github.syncgui.onlinestoreapi.models.User;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartDto {

    private User user;

    private List<Product> products;

    @Min(0)
    private Double totalAmount;
}
