package pl.gm.apidemo1.security.model;

import lombok.Builder;
import lombok.Data;
import pl.gm.apidemo1.security.utils.UserGender;

import java.time.LocalDate;

@Data
@Builder
public class UserInformation {

    private String firstName;
    private String lastName;
    private String profilePhotoUrl;
    private String country;
    private String occupation;
    private LocalDate dateOfBirth;
    private UserGender gender;

    public static UserInformation fromUser(UserResponse userResponse) {
        return UserInformation.builder()
                .firstName(userResponse.getFirstName())
                .lastName(userResponse.getLastName())
                .profilePhotoUrl(userResponse.getProfilePhotoUrl())
                .country(userResponse.getCountry())
                .country(userResponse.getCountry())
                .occupation(userResponse.getOccupation())
                .dateOfBirth(userResponse.getDateOfBirth())
                .gender(userResponse.getGender())
                .build();
    }

}
