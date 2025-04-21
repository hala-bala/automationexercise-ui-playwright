package org.example.halabalax.playwright.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class NewUser {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Date birthDate;
    private final Prefix prefix;
    private final String country;
    private final String city;
    private final String state;
    private final String address;
    private final String address2;
    private final String phoneNumber;
    private final String zipCode;

    @JsonCreator
    public NewUser(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("birthDate") Date birthDate,
            @JsonProperty("prefix") Prefix prefix,
            @JsonProperty("country") String country,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("address") String address,
            @JsonProperty("address2") String address2,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("zipCode") String zipCode
    ) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.prefix = prefix;
        this.country = country;
        this.city = city;
        this.state = state;
        this.address = address;
        this.address2 = address2;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

    public enum Prefix {
        MR, MRS, MS, DR, PROF
    }
}
