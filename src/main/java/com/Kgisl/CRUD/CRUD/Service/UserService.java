package com.Kgisl.CRUD.CRUD.Service;




 
import java.util.List;
 
import com.Kgisl.CRUD.CRUD.entity.User;
 
public interface UserService {
 
    public User createUser(User user);
    public List<User> getUsers();
    public User findByUserId(Long id);
    public User updateUser(Long id,User user);
    public void deleteUserById(Long id); 
 
}