package com.kamilcieslik.spring_boot.learninginterceptorslogging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact(
            "Kamil Cieślik", "https://github.com/kamilcieslik", "kamil.cieslik@protonmail.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
            .title("Wishes Reminder")
            .description("REST API dla aplikacji webowej umożliwiającej przeglądanie/edytowanie dat urodzin oraz " +
                    "imienin. Program pozwala na edycję danych osobowych użytkownika, logowanie/rejestrację, " +
                    "dodawanie danych bliskich użytkownikowi osób (relacja: członek rodziny, znajomy, " +
                    "przyjaciel.., data urodzenia, dane osobowe, dane adresowe) oraz pozwala na definiowanie " +
                    "szablonów życzeń, ich modyfikację oraz wysyłanie życzeń w formie listu/email do wybranych osób. " +
                    "Dane o zbliżających się rocznicach urodzin/imienin wyświetlane są w przystępnej formie " +
                    "(dzień urodzin/imienin, ilość dni do zbliżającej się rocznicy, data rocznicy).")
            .version("1.0")
            .contact(DEFAULT_CONTACT)
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .build();

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json",
                    "application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
