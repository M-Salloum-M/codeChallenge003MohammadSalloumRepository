package com.example.CodeChallenge003MohammadSalloum.controller;
import com.example.CodeChallenge003MohammadSalloum.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/validateNum")
public class ValidateNumberController {

    @PostMapping
    ResponseEntity<?> validate(@RequestBody String mobileNumber) {

        WebClient webClient = WebClient.create();
        ClientResponse response = webClient.get()
                .uri("https://phonevalidation.abstractapi.com/v1/?api_key=398f411e54ce4c479a33f207c9ab57ac&phone="+mobileNumber)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .block();
        System.out.println(response);
        Response apiResponse =response.bodyToMono(Response.class).block();
        if (apiResponse.getValid().equals(true)){

            return ResponseEntity.status(HttpStatus.OK).body("{\n" +
                    "countryCode:\""+apiResponse.getCountry().getCode() +",\n" +
                    "countryName:\""+apiResponse.getLocation() +",\n" +
                    "operatorName\""+apiResponse.getCarrier() +"\n" +
                    "}\n");}

        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Such MobileNumber");

    }
}
