package com.maverick.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "M_PERSON")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted_at is null")
public class PersonModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @Getter
    @Setter
    private String lastName;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    @Getter
    @Setter
    private Timestamp dateOfBirth;

    @Column(name = "IDENTITY_TYPE", nullable = false)
    @Getter
    @Setter
    private String identityType;

    @Column(name = "IDENTITY_NUMBER", nullable = false)
    @Getter
    @Setter
    private String identityNumber;

    @Column(name = "ADDRESS")
    @Getter
    @Setter
    private String address;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    @Getter
    @Setter
    private List<BookModel> authors;

}
