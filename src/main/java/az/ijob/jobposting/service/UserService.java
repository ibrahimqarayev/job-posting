package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.RegistrationDto;
import az.ijob.jobposting.model.Role;
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

    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoleList(Arrays.asList(role));
        userRepository.save(user);
    }

}
