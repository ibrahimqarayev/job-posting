package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.UserDto;
import az.ijob.jobposting.exception.UserNotFoundException;
import az.ijob.jobposting.model.User;
import az.ijob.jobposting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto register(String name, String surname, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);

        User savedUser = userRepository.save(user);

        return UserDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .surname(savedUser.getSurname())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();
    }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found !"));
        return Objects.equals(user.getPassword(), password);
    }

}
