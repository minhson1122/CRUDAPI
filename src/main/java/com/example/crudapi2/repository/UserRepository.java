package com.example.crudapi2.repository;

import com.example.crudapi2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    List<User> findByUser(User user);
}
