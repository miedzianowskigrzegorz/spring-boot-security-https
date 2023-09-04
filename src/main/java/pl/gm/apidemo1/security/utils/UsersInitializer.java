package pl.gm.apidemo1.security.utils;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.gm.apidemo1.security.model.UserForm;
import pl.gm.apidemo1.security.service.UserService;

@Component
@Slf4j
public class UsersInitializer {

    private final UserService userService;

    public UsersInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void admin() {
        UserForm adminRequest = new UserForm();
        adminRequest.setId(null);
        adminRequest.setEmail("admin");
        adminRequest.setPassword("123");
        adminRequest.setRole(UserRole.ADMIN);
        userService.saveUser(adminRequest);
        log.info("Created admin: " + adminRequest);
    }

    @PostConstruct
    public void user() {
        UserForm userRequest = new UserForm();
        userRequest.setId(null);
        userRequest.setEmail("user");
        userRequest.setPassword("123");
        userRequest.setRole(UserRole.USER);
        userService.saveUser(userRequest);
        log.info("Created user: " + userRequest);
    }
}
