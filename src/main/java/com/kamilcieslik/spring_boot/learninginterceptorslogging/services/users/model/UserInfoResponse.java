package com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoResponse {
    private Integer userId;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
    private String street;
    private String city;
    private String postalCode;
    private String country;
}
