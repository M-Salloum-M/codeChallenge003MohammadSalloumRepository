package com.example.CodeChallenge003MohammadSalloum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String address;

    @Pattern(regexp = "^[+0-9-]*$")
    @Column(nullable = false)
    private String mobileNumber;


}
