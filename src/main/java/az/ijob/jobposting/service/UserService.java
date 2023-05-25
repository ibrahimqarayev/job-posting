package az.ijob.jobposting.service;

import az.ijob.jobposting.model.User;
import az.ijob.jobposting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void register(String name,String surname,String email, String password){
        User user=new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }

}
