package com.piyush.tryJpa.tryJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorDTO {
    private int Book_ID;
    private String Book_Name;
    private String Author_Name;
}
