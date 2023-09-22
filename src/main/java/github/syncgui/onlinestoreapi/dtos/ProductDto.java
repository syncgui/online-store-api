package github.syncgui.onlinestoreapi.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Long id;

    @NotBlank
    private String name;

    @Min(0)
    private Double price;
}
