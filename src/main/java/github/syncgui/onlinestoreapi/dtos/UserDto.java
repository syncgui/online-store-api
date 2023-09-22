package github.syncgui.onlinestoreapi.dtos;

import github.syncgui.onlinestoreapi.validator.ExtendedEmailValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @ExtendedEmailValidator
    private String email;

    @NotBlank
    private String password;
}
