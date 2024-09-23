package ku.cs.kafe.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import ku.cs.kafe.validation.ValidPassword;
import lombok.Data;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @ValidPassword
    private String password;

    @NotBlank
    @Pattern(regexp = "^[a-zA-z]+$")
    private String name;
}
