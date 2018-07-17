package com.neppo.cursospringboot.CursoSpringBoot.config;


import com.neppo.cursospringboot.CursoSpringBoot.services.DBService;
import com.neppo.cursospringboot.CursoSpringBoot.services.EmailService;
import com.neppo.cursospringboot.CursoSpringBoot.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")

public class DevConfig {


    @Autowired
    private DBService dbService;


    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws Exception {

        if ("create".equals(strategy))
            dbService.instantiateTestDatabase();

        return true;
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }



}
