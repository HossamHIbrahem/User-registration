package com.homains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.homains.model.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    User findByEmail(String email);


}
