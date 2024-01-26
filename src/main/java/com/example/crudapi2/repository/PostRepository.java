package com.example.crudapi2.repository;

import com.example.crudapi2.model.Post;
import com.example.crudapi2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
List<Post> findAllByStatusContainingIgnoreCase(String status);
List<Post> findAllByOrderByLikesDesc();
List<Post> findAllByStatus(String status);
List<Post> findTop4ByOrderByLikesDesc();
}
