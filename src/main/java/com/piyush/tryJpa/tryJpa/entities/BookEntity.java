package com.piyush.tryJpa.tryJpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    
    @Id
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
}
