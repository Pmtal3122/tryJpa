package com.piyush.tryJpa.tryJpa.repositories;

import com.piyush.tryJpa.tryJpa.dto.BookAuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.piyush.tryJpa.tryJpa.entities.BookEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    // This interface will automatically provide CRUD operations for BookEntity
    // No need to define any methods unless you want custom queries

    @Query(value = """
            select b.id as Book_ID, b.name as Book_Name, a.name as Author_Name
            from book b inner join author a
            on b.author_id = a.id
            """, nativeQuery = true)
    public List<BookAuthorDTO> getBooksWithAuthorName();
    
}
