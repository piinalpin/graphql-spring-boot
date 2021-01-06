package com.maverick.graphql.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookForm {

    private Long authorId;

    private String title;

    private String publisher;

    private String description;

    private LocalDate releaseDate;

}
