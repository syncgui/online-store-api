package github.syncgui.onlinestoreapi.dtos;

import github.syncgui.onlinestoreapi.models.Product;
import github.syncgui.onlinestoreapi.models.User;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private User user;

    private List<Product> products;

    @Min(0)
    private Double totalAmount;
}
