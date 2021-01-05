package com.maverick.graphql.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonForm {

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String identityType;

    private String identityNumber;

    private String address;

}
