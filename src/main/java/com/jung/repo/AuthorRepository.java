package com.jung.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jung.domain.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
