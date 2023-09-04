package pl.gm.apidemo1.security.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gm.apidemo1.security.model.User;
import pl.gm.apidemo1.security.model.UserForm;
import pl.gm.apidemo1.security.model.UserResponse;
import pl.gm.apidemo1.security.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Saves a user to the database.
     * Password has been encoded.
     *
     * @param userRequest The user request to be saved.
     */
    public void saveUser(UserForm userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
    }

    /**
     * Retrieves all users and maps them to responses.
     *
     * @return A list of user responses.
     */
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(u -> modelMapper.map(u, UserResponse.class))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a user by email address and maps them to a response.
     *
     * @param email The email address of the user to retrieve.
     * @return A user response or null if the user doesn't exist.
     */
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return modelMapper.map(user, UserResponse.class);
    }

    /**
     * Updates a user with the provided user data.
     *
     * @param userToUpdate The UserResponse object containing the updated user data.
     */
    public void updateUser(UserResponse userToUpdate) {
        User user = modelMapper.map(userToUpdate,User.class);
        userRepository.save(user);
    }

    /**
     * Delete user from repository.
     *
     * @param id  of the user to remove.
     */
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
