package com.demo.spring.jpa;

import com.demo.spring.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
