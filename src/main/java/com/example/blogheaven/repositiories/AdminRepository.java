package com.example.blogheaven.repositiories;

import com.example.blogheaven.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
}
