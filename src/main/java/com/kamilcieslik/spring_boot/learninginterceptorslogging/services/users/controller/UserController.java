package com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.controller;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.model.UserInfoResponse;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.service.UserService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/app/rest/services/users")
    public ResponseEntity<Iterable<UserInfoResponse>> getUsersInfo(
            @RequestHeader(value = "correlationId", required = false) String correlationId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("correlationId", MDC.get("correlationId"));

        return new ResponseEntity<>(userService.getUsersInfo(), httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/app/rest/services/users/{id}")
    public ResponseEntity<UserInfoResponse> getUserInfo(
            @RequestHeader(value = "correlationId", required = false) String correlationId,
            @PathVariable("id") @Pattern(regexp = "[0-9]*", message = "Wrong format of user id") String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("correlationId", MDC.get("correlationId"));

        return new ResponseEntity<>(userService.getUserInfo(Integer.valueOf(id)), httpHeaders, HttpStatus.OK);
    }
}
