package com.kamilcieslik.spring_boot.learninginterceptorslogging.cucumber;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.LearningInterceptorsLoggingApplication;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = "src/test/resources/features",
        glue = {"com.kamilcieslik.spring_boot.learninginterceptorslogging.bdd.glue"})
@SpringBootTest(classes = LearningInterceptorsLoggingApplication.class)
public class CucumberTest {}
