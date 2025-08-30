package com.piyush.tryJpa.tryJpa.dto;

import com.piyush.tryJpa.tryJpa.entities.AuthorEntity;
import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class AddBookDto {
    private Integer id;
    @Nonnull
    private String name;
    private Integer authorId;
    private AuthorEntity author;
}
