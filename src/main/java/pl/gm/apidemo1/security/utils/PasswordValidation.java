package pl.gm.apidemo1.security.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = "Password is required")
@Size(min = 3, max = 16, message = "The password '${validatedValue}' must be between {min} and {max} length.")
@Constraint(validatedBy = {})
public @interface PasswordValidation {
    String message() default "Invalid password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
