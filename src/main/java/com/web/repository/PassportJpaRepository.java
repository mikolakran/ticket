package com.web.repository;

import com.web.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportJpaRepository extends JpaRepository<Passport,Long> {
}
