package com.fundamentosplatzi.sprintboot.fundamentos.repository;

import com.fundamentosplatzi.sprintboot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
