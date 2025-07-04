package com.piyush.tryJpa.tryJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyush.tryJpa.tryJpa.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    // This interface will automatically provide CRUD operations for BookEntity
    // No need to define any methods unless you want custom queries
    
}
