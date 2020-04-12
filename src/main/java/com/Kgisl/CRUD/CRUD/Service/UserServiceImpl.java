package com.Kgisl.CRUD.CRUD.Service;




 
import java.util.List;
 
import javax.transaction.Transactional;
 
import com.Kgisl.CRUD.CRUD.entity.User;
import com.Kgisl.CRUD.CRUD.Repository.UserRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class UserServiceImpl implements UserService {
 
    @Autowired
    UserRepository userRepository;
 
    public User createUser(User user) {
        return userRepository.save(user);
    }
 
    public List<User> getUsers() {
        return userRepository.findAll();
    }
 
    public User findByUserId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }
 
    public User updateUser(Long id,User user) {
        User u = userRepository.getOne(id);
        u.setUsername(user.getUsername());
        return userRepository.save(u);
    }
 
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
 
}