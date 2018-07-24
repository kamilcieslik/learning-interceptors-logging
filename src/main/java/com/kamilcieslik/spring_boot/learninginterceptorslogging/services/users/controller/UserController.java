package com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.controller;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.model.UserInfoResponse;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/services/users")
    public ResponseEntity<Iterable<UserInfoResponse>> getUsersInfo(){
        return new ResponseEntity<>(userService.getUsersInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "/services/users/{id}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUserInfo(id), HttpStatus.OK);
    }
}
