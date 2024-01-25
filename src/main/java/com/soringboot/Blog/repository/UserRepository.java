package com.soringboot.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soringboot.Blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
