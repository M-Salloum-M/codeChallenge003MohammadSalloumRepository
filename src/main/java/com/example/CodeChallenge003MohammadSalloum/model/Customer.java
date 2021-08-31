package com.example.CodeChallenge003MohammadSalloum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import javax.validation.constraints.Pattern;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("CUSTOMER")
//@Table(name = "customer")

public class Customer implements Serializable {
//    private static final long serialVersionUID = -8271783343856328980L;
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String address;

    @Pattern(regexp = "^[+0-9-]*$")
    @Column(nullable = false)
    private String mobileNumber;
}
