package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.demo.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
