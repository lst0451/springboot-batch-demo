package com.lstdemo.springbootbatchdemo.repository;

import com.lstdemo.springbootbatchdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
