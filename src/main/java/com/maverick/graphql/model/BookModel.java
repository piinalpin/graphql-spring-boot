package com.maverick.graphql.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "M_BOOK")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted_at is null")
public class BookModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @Getter
    @Setter
    private PersonModel author;

    @Column(name = "TITLE", nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(name = "PUBLISHER", nullable = false)
    @Getter
    @Setter
    private String publisher;

    @Column(name = "DESCRIPTION")
    @Getter
    @Setter
    private String description;

    @Column(name = "RELEASE_DATE", nullable = false)
    @Getter
    @Setter
    private Timestamp releaseDate;

}
