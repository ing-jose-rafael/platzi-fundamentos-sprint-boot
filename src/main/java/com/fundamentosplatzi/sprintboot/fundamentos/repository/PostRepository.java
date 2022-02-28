package com.fundamentosplatzi.sprintboot.fundamentos.repository;

import com.fundamentosplatzi.sprintboot.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
