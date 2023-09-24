package github.syncgui.onlinestoreapi.dtos;

import github.syncgui.onlinestoreapi.validator.ExtendedEmailValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
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
