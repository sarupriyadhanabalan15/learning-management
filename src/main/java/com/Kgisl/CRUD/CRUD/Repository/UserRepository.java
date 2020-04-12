package com.Kgisl.CRUD.CRUD.Repository;
 
import com.Kgisl.CRUD.CRUD.entity.User;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UserRepository extends JpaRepository<User,Long>{
 

}

