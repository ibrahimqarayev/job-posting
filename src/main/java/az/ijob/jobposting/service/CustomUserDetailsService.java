package az.ijob.jobposting.service;

import az.ijob.jobposting.model.User;
import az.ijob.jobposting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByUsername(username);
        if (user != null) {
            User authUser = new User(
                    user.getId(),
                    user.getName(),
                    user.getSurname(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoleList().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())

            );

            return authUser;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
