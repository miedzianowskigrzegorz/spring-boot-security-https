package pl.gm.apidemo1.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gm.apidemo1.security.utils.UserGender;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePhotoUrl;
    private String country;
    private String occupation;
    private LocalDate dateOfBirth;
    private UserGender gender;
    private String role;

    public static UserResponse updateInformation(UserResponse user,UserInformation userInformation) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(userInformation.getFirstName())
                .lastName(userInformation.getLastName())
                .profilePhotoUrl(userInformation.getProfilePhotoUrl())
                .country(userInformation.getCountry())
                .occupation(userInformation.getOccupation())
                .dateOfBirth(userInformation.getDateOfBirth())
                .gender(userInformation.getGender())
                .role(user.getRole())
                .build();
    }

}
