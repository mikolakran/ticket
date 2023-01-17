package com.web.repository;
import com.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
