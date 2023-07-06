package az.ijob.jobposting.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Size(min = 3,max = 15 ,message = "Ad uzunluğu 3-15 simvol aralığında olmalıdır")
    private String name;
    @Size(min = 3,max = 20 ,message = "Soyad uzunluğu 3-20 simvol aralığında olmalıdır")
    private String surname;
    @Email(message = "Email formatı düzgün deyil")
    private String email;
    @Size(min = 8,max = 30 ,message = "Şifrə uzunluğu 8-30 simvol aralığında olmalıdır")
    private String password;
    private String repeatPassword;

}
