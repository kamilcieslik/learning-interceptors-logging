package com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.service;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.exceptions.InternalException;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.dao.UserDAO;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity.Address;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity.User;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.model.UserInfoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;

    public Iterable<UserInfoResponse> getUsersInfo() {
        return StreamSupport.stream(userDAO.findAll().spliterator(), false)
                .filter(user -> Optional.ofNullable(user.getAddress()).isPresent())
                .map(user -> UserInfoResponse.builder()
                        .userId(user.getId())
                        .login(user.getLogin())
                        .firstName(user.getPassword())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .addressId(user.getAddress().getId())
                        .street(user.getAddress().getStreet())
                        .city(user.getAddress().getCity())
                        .postalCode(user.getAddress().getPostalCode())
                        .country(user.getAddress().getCountry())
                        .build()).collect(Collectors.toList());
    }

    public UserInfoResponse getUserInfo(Integer userId) {
        Optional<User> optionalUserInfoResponse = userDAO.findById(userId);

        if (!optionalUserInfoResponse.isPresent())
            throw new InternalException("Nie znaleziono użytkownika o wskazanym ID.", HttpStatus.NOT_FOUND);

        User user = optionalUserInfoResponse.get();
        Optional<Address> optionalAddress = Optional.ofNullable(user.getAddress());

        if (!optionalAddress.isPresent())
            throw new InternalException("Użytkownik o wskazanym ID nie posiada danych adresowych.", HttpStatus.NOT_FOUND);

        Address address = optionalAddress.get();

        return UserInfoResponse.builder().userId(user.getId())
                .login(user.getLogin())
                .firstName(user.getPassword())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .addressId(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .build();
    }

}