package pl.gm.apidemo1.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gm.apidemo1.security.utils.EmailValidation;
import pl.gm.apidemo1.security.utils.PasswordValidation;
import pl.gm.apidemo1.security.utils.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private Long id;

    @EmailValidation
    private String email;

    @PasswordValidation
    private String password;

    @PasswordValidation
    private String repeatedPassword;

    private UserRole role;

}
