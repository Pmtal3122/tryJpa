package com.piyush.tryJpa.tryJpa.repositories;

import com.piyush.tryJpa.tryJpa.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
