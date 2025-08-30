package com.piyush.tryJpa.tryJpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "library_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUser {
    @Id
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
}
