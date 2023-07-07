package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.UserDto;
import az.ijob.jobposting.model.User;
import az.ijob.jobposting.repository.RoleRepository;
import az.ijob.jobposting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(Arrays.asList(roleRepository.findByName("USER")));
        userRepository.save(user);
        return user;
    }


}
