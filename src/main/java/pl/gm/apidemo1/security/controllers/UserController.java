package pl.gm.apidemo1.security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gm.apidemo1.security.model.UserInformation;
import pl.gm.apidemo1.security.model.UserResponse;
import pl.gm.apidemo1.security.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile-json")
    @ResponseBody
    public UserResponse profileJson(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getUserByEmail(userDetails.getUsername());
    }

    @GetMapping("/profile")
    public String profile(
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {
        UserResponse user = userService.getUserByEmail(userDetails.getUsername());
        model.addAttribute("userInformation", UserInformation.fromUser(user));
        return "user/profile";
    }

    @PostMapping("/profile-save")
    public String saveProfile(
            @AuthenticationPrincipal UserDetails userDetails,
            UserInformation userInformation
    ) {
        UserResponse userToUpdate = userService.getUserByEmail(userDetails.getUsername());

        UserResponse updatedUser = UserResponse.updateInformation(userToUpdate, userInformation);

        userService.updateUser(updatedUser);
        return "redirect:/api/users/profile-json";
    }
}
