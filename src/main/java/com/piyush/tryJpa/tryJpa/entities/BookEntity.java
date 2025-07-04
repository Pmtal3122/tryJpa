package com.piyush.tryJpa.tryJpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    
    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
}
