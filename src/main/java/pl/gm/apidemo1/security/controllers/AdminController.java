package pl.gm.apidemo1.security.controllers;

import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gm.apidemo1.security.model.UserForm;
import pl.gm.apidemo1.security.model.UserResponse;
import pl.gm.apidemo1.security.service.UserService;

@Controller
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/user-form")
    public String userForm(Model model) {
        model.addAttribute("user", new UserForm());
        return "user/create";
    }

    @PostMapping("/user-submit")
    public String submitForm(@ModelAttribute("user") @Valid UserForm user, BindingResult bindingResult) {
        if (!user.getPassword().equals(user.getRepeatedPassword())) {
            bindingResult.rejectValue("repeatedPassword", "password.mismatch", "Passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            return "user/create";
        }

        userService.saveUser(user);
        return "redirect:/api/admin";
    }

    @GetMapping("/users-list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list";
    }

    @GetMapping("/user-delete/{userId}")
    @ResponseBody
    public String deleteUser(@PathVariable("userId") Long userId, @AuthenticationPrincipal UserDetails userDetails) {
        UserResponse userResponse = userService.getUserByEmail(userDetails.getUsername());
        if (userId.equals(userResponse.getId())) {
            return "U cant remove yourself.";
        }
        userService.delete(userId);
        return "User with id :: " + userId + " has been removed.";
    }
}
