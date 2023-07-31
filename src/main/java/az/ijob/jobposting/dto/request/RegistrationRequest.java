package az.ijob.jobposting.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String name;

    private String surname;

    private String email;

    private String password;

    private String repeatPassword;
}
