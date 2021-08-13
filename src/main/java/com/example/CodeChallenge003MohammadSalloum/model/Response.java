package com.example.CodeChallenge003MohammadSalloum.model;

import com.example.CodeChallenge003MohammadSalloum.model.responseAdd.Country;
import com.example.CodeChallenge003MohammadSalloum.model.responseAdd.FormatClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    String phone;
    Boolean valid;
    Country country;
    FormatClass format;
    String location;
    String type;
    String carrier;

}
